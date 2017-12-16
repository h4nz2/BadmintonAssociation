package badminton_association.com.example.honza.badmintonassociation.ListAdapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import badminton_association.com.example.honza.badmintonassociation.Activities.MainActivity;
import badminton_association.com.example.honza.badmintonassociation.HTTPInterface;
import badminton_association.com.example.honza.badmintonassociation.Models.Participate;
import badminton_association.com.example.honza.badmintonassociation.Models.Tournament;
import badminton_association.com.example.honza.badmintonassociation.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Honza on 16/12/2017.
 */

public class PlayerTournamentsListAdapter extends RecyclerView.Adapter<PlayerTournamentsListAdapter.ViewHolder> {
    private List<Tournament> mTournaments;
    private Boolean clickable;
    private final Context mContext;
    private int playerID;

    public PlayerTournamentsListAdapter(List<Tournament> tournaments, Boolean clickable, Context context, int playerID){
        this.mTournaments = tournaments;
        this.clickable = clickable;
        this.mContext = context;
        this.playerID = playerID;
    }

    @Override
    public PlayerTournamentsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_tournaments_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayerTournamentsListAdapter.ViewHolder holder, int position) {
        holder.populateRow(mTournaments.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mTournaments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView startdate;
        private TextView endDate;
        private int tournamentID;

        public ViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            startdate = (TextView) view.findViewById(R.id.startDate);
            endDate = (TextView) view.findViewById(R.id.endDate);
            if(clickable)
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final View view = v;
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
                        alertDialogBuilder.setCancelable(false);
                        alertDialogBuilder.setTitle("Join tournament ?");
                        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RestAdapter radapter=new RestAdapter.Builder().setEndpoint(MainActivity.URL).build();

                                HTTPInterface restInt = radapter.create(HTTPInterface.class);

                                restInt.joinPlayerTournament(new Participate(playerID, tournamentID), new Callback<Object>() {
                                    @Override
                                    public void success(Object o, Response response) {
                                        Log.d("joinTournament", "success");
                                    }

                                    @Override
                                    public void failure(RetrofitError error) {
                                        Log.d("joinTournament", error.getMessage());
                                    }
                                });
                            }
                        });
                        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alertDialogBuilder.show();
                    }
                });
        }

        public void populateRow(Tournament tournament, int position){
            name.setText(tournament.getName());
            startdate.setText(tournament.getStartDate().toString());
            endDate.setText(tournament.getEndDate().toString());
            tournamentID = tournament.getId();
        }
    }
}

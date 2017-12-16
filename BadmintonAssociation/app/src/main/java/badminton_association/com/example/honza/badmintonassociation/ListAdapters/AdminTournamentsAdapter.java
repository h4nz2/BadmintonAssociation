package badminton_association.com.example.honza.badmintonassociation.ListAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import badminton_association.com.example.honza.badmintonassociation.Models.Tournament;
import badminton_association.com.example.honza.badmintonassociation.R;

/**
 * Created by Honza on 16/12/2017.
 */

public class AdminTournamentsAdapter extends RecyclerView.Adapter<AdminTournamentsAdapter.ViewHolder> {
    private List<Tournament> mTournaments;
    private Context mContext;

    public AdminTournamentsAdapter(List<Tournament> tournaments, Context context) {
        this.mTournaments = tournaments;
        this.mContext = context;
    }

    @Override
    public AdminTournamentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_tournaments_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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

        public ViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            startdate = (TextView) view.findViewById(R.id.startDate);
            endDate = (TextView) view.findViewById(R.id.endDate);
        }

        public void populateRow(Tournament tournament, int position){
            name.setText(tournament.getName());
            startdate.setText(tournament.getStartDate().toString());
            endDate.setText(tournament.getEndDate().toString());
        }
    }
}

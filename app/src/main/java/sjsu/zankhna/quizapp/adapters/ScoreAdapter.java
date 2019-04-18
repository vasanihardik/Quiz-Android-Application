package sjsu.zankhna.quizapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sjsu.zankhna.quizapp.R;
import sjsu.zankhna.quizapp.db.entity.ScoreEntity;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {

    List<ScoreEntity> scores;
    private Context context;

    public ScoreAdapter(List<ScoreEntity> scores, Context context) {
        this.scores = scores;
        this.context = context;
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View scoreItemView = inflater.inflate(R.layout.item_score, parent, false);
        return new ScoreViewHolder(scoreItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder scoreViewHolder, int i) {
        ScoreEntity score = scores.get(i);
        scoreViewHolder.date.setText(score.getDate().toString());
        scoreViewHolder.category.setText(score.getCategory());
        scoreViewHolder.score.setText(score.getScore());
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    public class ScoreViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_date)
        TextView date;
        @BindView(R.id.txt_category)
        TextView category;
        @BindView(R.id.txt_score)
        TextView score;

        public ScoreViewHolder(@NonNull View scoreItemView) {
            super(scoreItemView);
            ButterKnife.bind(this, scoreItemView);
        }
    }
}
package tr.edu.mu.ceng.mad.myapplicationme;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tr.edu.mu.ceng.mad.myapplicationme.dummy.DummyContent.DummyItem;

import java.util.ArrayList;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCoursesRecyclerViewAdapter extends
        RecyclerView.Adapter<MyCoursesRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Course> mValues;
    private CoursesFragment.OnCourseListInteractionListener mListener;

    public MyCoursesRecyclerViewAdapter(ArrayList<Course> mValues,
                                        CoursesFragment.OnCourseListInteractionListener
                                                mListener) {
        this.mValues = mValues;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_courses, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Course courses = mValues.get(position);
        //holder.mItem = mValues.get(position);
        holder.mCourseView.setText(mValues.get(position).getCourse_name());
        holder.mTeacherView.setText(mValues.get(position).getTeacher_name());
        holder.note_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(null != mListener){
                    mListener.onCourseSelected(holder.mItem);
                }*/

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //public final View mView;
        public final TextView mCourseView;
        public final TextView mTeacherView;
        public final CardView note_card;
        public Course mItem;

        public ViewHolder(View view) {
            super(view);
            //mView = view;
            mCourseView = view.findViewById(R.id.textView);
            mTeacherView = view.findViewById(R.id.textView2);
            note_card = view.findViewById(R.id.note_card);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mCourseView.getText() + "'";
        }
    }
}
package tr.edu.mu.ceng.mad.myapplicationme;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A fragment representing a list of Items.
 */
public class CoursesFragment extends Fragment implements View.OnClickListener {

    // TODO: Customize parameter argument names
    private static final String ARG_COURSE = "course";
    private OnCourseListInteractionListener mListener;
    private ArrayList<Course> courses;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CoursesFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CoursesFragment newInstance(ArrayList<Course> courses) {
        CoursesFragment fragment = new CoursesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_COURSE, courses);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (getArguments() != null) {
            courses = (ArrayList<Course>)getArguments().getSerializable(ARG_COURSE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses_list, container,
                false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new MyCoursesRecyclerViewAdapter(courses, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnCourseListInteractionListener){
            mListener=(OnCourseListInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()+
                    " should implement OnCourseListInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener=null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.courses_floatingActionButton_add:
                startActivity(new Intent(getContext(),
                        CourseDetailsActivity.class));
                break;
        }
    }


    public interface OnCourseListInteractionListener{
        void onCourseSelected(Course course);
    }

}
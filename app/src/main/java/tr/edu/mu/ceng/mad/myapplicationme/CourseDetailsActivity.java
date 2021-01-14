package tr.edu.mu.ceng.mad.myapplicationme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CourseDetailsActivity extends AppCompatActivity {
    private EditText textCourseName, textTeacherName;
    private Button buttonSave, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        textCourseName= findViewById(R.id.courseDetails_textCourseName);
        textTeacherName= findViewById(R.id.courseDetails_textTeacherName);
        buttonSave= findViewById(R.id.courseDetails_buttonSave);
        buttonBack= findViewById(R.id.courseDetails_buttonBack);


    }

    public void onSaveClick(View view) {

    }

    public void onCloseClick(View view) {
        finish();
    }
}
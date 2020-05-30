import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';
import { HttpClient } from '@angular/common/http';
import { Course } from 'src/app/models/course/Course';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-manage-courses',
  templateUrl: './manage-courses.component.html',
  styleUrls: ['./manage-courses.component.scss']
})
export class ManageCoursesComponent implements OnInit {

  addCourseForm: FormGroup;
  favoriteSeason: string;
  seasons: string[] = ['Add Course', 'Modify/Delete Course'];

  constructor(
    public formBuilder: FormBuilder,
    public session: SessionStorageService,
    public router: Router,
    public http: HttpClient,
    private snackBar: MatSnackBar) {

    this.addCourseForm = new FormGroup({
      name: new FormControl('', Validators.required),
      location: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      prerequisites: new FormControl('', Validators.required),
      skills: new FormControl('', Validators.required),
    });
    this.addCourseForm.reset();
  }

  ngOnInit() {

  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 4000,
    });
  }

  addCourse() {
    const obj = new Course();

    obj.courseName = this.addCourseForm.value.name;
    obj.courseLocation = this.addCourseForm.value.location;
    obj.courseDescription = this.addCourseForm.value.description;
    obj.courseSkills = this.addCourseForm.value.skills;
    obj.coursePrerequisites = this.addCourseForm.value.prerequisites;
    obj.courseAdminId = this.session.get('user').empId;

    console.log(obj);


    this.http.post('/api/course/addCourse', obj).subscribe((Response) => {
      console.log(Response);
      this.openSnackBar('Course Added Successfully', 'Done');
      window.location.reload();
    });
  }




}

import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Course } from 'src/app/models/course/Course';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { UploadFileComponent } from '../upload-file/upload-file.component';
import { ViewDeleteFileComponent } from '../view-delete-file/view-delete-file.component';

@Component({
  selector: 'app-my-courses',
  templateUrl: './my-courses.component.html',
  styleUrls: ['./my-courses.component.scss']
})

export class MyCoursesComponent implements OnInit {

  trainerId: number;
  courses: Course[] = [];

  constructor(
    public session: SessionStorageService,
    public router: Router,
    public http: HttpClient,
    private snackBar: MatSnackBar,
    public dialog: MatDialog) {

    this.trainerId = this.session.get('user').empId;
    this.http.get('/api/course/trainer/' + this.trainerId).subscribe((response: Course[]) => {
      this.courses = response;
      console.log(this.courses);
      this.ngOnInit();
    });
  }

  ngOnInit() {

  }

  openAddDialog(id) {

    this.dialog.open(UploadFileComponent, {
      data: {
        courseId: id
      }
    },
    );
  }

  openDeleteDialog(id) {

    this.dialog.open(ViewDeleteFileComponent, {
      data: {
        courseId: id
      }
    },
    );
  }

}

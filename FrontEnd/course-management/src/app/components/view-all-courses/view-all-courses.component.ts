import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort } from '@angular/material';
import { MatTableDataSource } from '@angular/material/table';
import { HttpClient } from '@angular/common/http';
import { Course } from 'src/app/models/course/Course';
import { SocialloginService } from '../../providers/login/sociallogin.service';
import { Router } from '@angular/router';
import { ManageCourseService } from '../../providers/manage-courses/manage-course.service';

@Component({
  selector: 'app-view-all-courses',
  templateUrl: './view-all-courses.component.html',
  styleUrls: ['./view-all-courses.component.scss']
})

export class ViewAllCoursesComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'location', 'description', 'prerequisites', 'skills'];
  COURSE_DATA: Course[] = [];
  dataSource: MatTableDataSource<Course>;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(
    private http: HttpClient,
    private router: Router,
    public loginService: SocialloginService,
    public service: ManageCourseService,
  ) {

  }

  ngOnInit() {
    if (!this.loginService.getLoginStatus()) {
      alert('You are not logged in !!!');
      this.router.navigate(['/login']);
    } else {
      this.service.getAllCourses().subscribe((response: Course[]) => {

        this.COURSE_DATA = response;
        console.log(this.COURSE_DATA);

        this.dataSource = new MatTableDataSource(this.COURSE_DATA);
        this.dataSource.data = this.COURSE_DATA;


        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;

        console.log(this.dataSource);
      });
    }
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}

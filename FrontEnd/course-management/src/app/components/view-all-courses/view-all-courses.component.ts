import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort } from '@angular/material';
import { MatTableDataSource } from '@angular/material/table';
import { HttpClient } from '@angular/common/http';
import { Course } from 'src/app/models/course/Course';

@Component({
  selector: 'app-view-all-courses',
  templateUrl: './view-all-courses.component.html',
  styleUrls: ['./view-all-courses.component.scss']
})

export class ViewAllCoursesComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'location', 'description', 'prerequisites', 'skills'];
  COURSE_DATA: Course[] = [];
  dataSource: MatTableDataSource<Course>;
  dataLength;


  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get('api/course/all').subscribe((response: Course[]) => {

      this.COURSE_DATA = response;
      console.log(this.COURSE_DATA);

      this.dataSource = new MatTableDataSource(this.COURSE_DATA);
      this.dataSource.data = this.COURSE_DATA;

      this.dataLength = response.length;

      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;

      console.log(this.dataSource);
    });
  }

  onChange(event: Event) {
    console.log(event);
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Course } from '../../models/course/Course';
import { Training } from 'src/app/models/training/Training';

@Injectable({
  providedIn: 'root'
})

export class ManageCourseService {


  constructor(public http: HttpClient) { }

  getAllCourses() {
    return this.http.get('api/course/all');
  }

  addCourse(obj: Course) {
    return this.http.post('/api/course/addCourse', obj);
  }

  editCourse(obj: Course) {
    return this.http.post('/api/course/updateCourse', obj);
  }

  getAllEmployees() {
    return this.http.get('/api/training/getAllEmployees');
  }

  addOrEditTrainer(courseId: number) {
    return this.http.get('/api/training/getTrainersByCourseId/' + courseId);
  }

  unAssignTrainer(obj: Training) {
    return this.http.post('/api/training/unassignTrainers', obj);
  }

  assignTrainer(obj: Training) {
    return this.http.post('/api/training/assignTrainers', obj);
  }

  deleteCourse(course: Course) {
    return this.http.post('api/course/deleteCourse', course);
  }

  getAllCoursesForCurrentTrainer(trainerId: number) {
    return this.http.get('/api/course/trainer/' + trainerId);
  }

}

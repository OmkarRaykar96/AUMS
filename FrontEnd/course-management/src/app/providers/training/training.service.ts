import { Injectable } from '@angular/core';
import { Course } from '../../models/course/Course';
import { HttpClient } from '@angular/common/http';
import { SessionStorageService } from 'angular-web-storage';
import { Email } from 'src/app/models/training/Email';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {
  sendMail(course: Course, trainerId: number, emailId: string) {
    console.log('Sending Mail with message');
    const subject = 'AU Course Management System Autogenerated Mail';
    // console.log(course);

    const mail = new Email();
    mail.courseName = course.courseName as string;
    mail.courseDescription = course.courseDescription as string;
    mail.courseLocation = course.courseLocation as string;
    mail.courseSkills = course.courseSkills as string;
    mail.coursePrerequisites = course.coursePrerequisites as string;
    mail.mailRecepient = emailId as string;

    mail.trainerName = this.session.get('user').empName;
    mail.mailSubject = subject;

    console.log(mail);

    return this.http.post('api/training/sendMail/', mail);
  }

  constructor(public session: SessionStorageService, private http: HttpClient) { }
}

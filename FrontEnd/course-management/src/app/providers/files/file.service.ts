import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FileService {
  deleteTraining(fileId: number) {
    return this.http.post('api/trainingMaterial/delete', fileId);
  }

  constructor(private http: HttpClient) { }

  addTrainingMaterial(fileList, courseId, trainerId) {
    const formData: FormData = new FormData();

    for (const obj of fileList) {
      formData.append('files[]', obj);
    }

    formData.append('courseId', courseId.courseId);
    formData.append('trainerId', trainerId);
    const headers = { headers: new HttpHeaders({ enctype: 'multipart/form-data' }) };
    return this.http.post('api/trainingMaterial/add', formData, headers);
  }

  getTrainingMaterial(courseId: number, trainerId: number) {
    return this.http.get('api/trainingMaterial/files/' + courseId + '/' + trainerId);
  }

}

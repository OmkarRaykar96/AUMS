import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SessionStorageService } from 'angular-web-storage';

@Injectable({
  providedIn: 'root'
})

export class SocialloginService {
  url;

  loggedIn: boolean;

  constructor(private http: HttpClient, public session: SessionStorageService) {
    if (this.session.get('user')) {
      this.loggedIn = true;
    } else {
      this.loggedIn = false;
    }
  }

  Savesresponse(responce) {
    this.url = 'http://localhost:64726/Api/Login/Savesresponse';
    return this.http.post(this.url, responce);
  }

  setLoginStatus(val: boolean) {
    this.loggedIn = val;
  }

  getLoginStatus() {
    return this.loggedIn;
  }

}

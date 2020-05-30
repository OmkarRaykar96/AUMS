import { Component, OnInit } from '@angular/core';
import { SocialLoginModule, AuthServiceConfig, AuthService } from 'angular-6-social-login';
import { Socialusers } from '../../models/login/Socialusers';
import { SocialloginService } from '../../providers/login/sociallogin.service';
import { Router } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})

export class DashboardComponent implements OnInit {
  socialusers = new Socialusers();

  constructor(public OAuth: AuthService, private router: Router, private session: SessionStorageService) {
    if (this.session.get('reload')) {
      this.session.set('reload', false);
      window.location.reload();
    }
    this.router.navigate(['/dashboard']);
  }

  ngOnInit() {
    this.socialusers = JSON.parse(localStorage.getItem('socialusers'));
  }

  getImgUrl() {
    return 'url(' + this.session.get('user').empImage + ')';
  }
}

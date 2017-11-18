import { Component, OnInit } from '@angular/core'
import {DomSanitizer, SafeStyle} from '@angular/platform-browser';


@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
  template: `
      <div [style]="getStyle()">
  `
})
export class MapComponent implements OnInit {
  showStyle = false;
  chosenCountry = "";

  constructor() { }

  ngOnInit() {
  }
	
	getStyle() {
    const profilePicUrl = 'assets/images/background.pngsome-remote-server-url.jpg';
    const style = `background-image: url(${profilePicUrl})`;
    return this.sanitizer.bypassSecurityTrustStyle(style);
  }

}

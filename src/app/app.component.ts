import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public showAccueil:boolean = true;
  public showFormulaire:boolean = false;

   toggleAccueil() {
      this.showAccueil = true;
      this.showFormulaire = false;
    }

   toggleFormulaire() {
      this.showFormulaire = true;
      this.showAccueil = false;
   }

  title = 'projetBearOrNotToBear';
}

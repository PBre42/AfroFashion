import { GameService } from './../service/game.service';
import { Observable } from 'rxjs';
import { ParcoursReponse } from './../model/parcours-reponse';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  parcoursReponse$: ParcoursReponse | undefined 
  url:string|undefined
  public show:boolean = false
  id=0
  idGauche=1
  idDroite=5

  constructor(private gameService:GameService,private router: Router,private routeA: ActivatedRoute) { }

  ngOnInit(): void {
    
    if(this.routeA.snapshot.params['id']){
      
    this.id = this.routeA.snapshot.params['id'];    
    if(this.id==4){ 
      this.router.navigate(['article']);
    }
    this.gameService.getParcoursById(this.id).subscribe( data =>{
      this.parcoursReponse$ = data;
      this.url=data.parcours.etapeDepart.video;
      this.idGauche=data.reponses[0].id;
      this.idDroite=data.reponses[1].id;
      console.log(data);

    });
  }else{
    
    this.retrieveParcoursWithResponse();
  }
  }
  videoEnd(){
    this.show = !this.show;
  }

  retrieveParcoursWithResponse() {
    this.gameService.getAll()
      .subscribe(
        data => {
          this.parcoursReponse$ = data;
          this.url=data.parcours.etapeDepart.video;
          this.idGauche=data.reponses[0].id;
          this.idDroite=data.reponses[1].id;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  response(id: number){
    this.router.navigateByUrl('', { skipLocationChange: true }).then(() => { this.router.navigate(['game',id]); });
    
  }


}

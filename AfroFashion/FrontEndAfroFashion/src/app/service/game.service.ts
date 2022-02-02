import { ParcoursReponse } from './../model/parcours-reponse';

import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  constructor(private http: HttpClient) { }
  private baseUrl = 'http://localhost:8081/game/';
  getAll() :Observable<ParcoursReponse>{
    return this.http.get<ParcoursReponse>(this.baseUrl);
  }
  getParcoursById(id: number): Observable<ParcoursReponse>{
    return this.http.get<ParcoursReponse>(`${this.baseUrl}${id}`);
  }

}

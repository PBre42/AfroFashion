import { Observable, BehaviorSubject } from 'rxjs';
import { Article } from './../model/article';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private baseURL='http://localhost:8081/article/';
  private readonly articles$: BehaviorSubject<Article[]> = new BehaviorSubject<Article[]>([]);
  constructor(private http: HttpClient) { }
  fetchList() {
    this.http.get<Article[]>(this.baseURL)
      .subscribe(data => this.articles$.next(data));
  }
  get articles(): Observable<Article[]> {
    return this.articles$.asObservable();
  }
}

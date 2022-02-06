import { Observable } from 'rxjs';
import { Article } from './../model/article';
import { ArticleService } from './../service/article.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  articles: Observable<Article[]> | undefined;
  constructor(private readonly articleService: ArticleService) {}

  ngOnInit() {
   this.getArticleList();
  }
  private getArticleList(){
   
    this.articles = this.articleService.articles;

    this.articleService.fetchList();
  
  }
}

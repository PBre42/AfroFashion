import { HomeComponent } from './home/home.component';
import { ArticleComponent } from './article/article.component';
import { GameComponent } from './game/game.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'game', component: GameComponent },
  { path: 'game/:id', component: GameComponent },
  { path: 'article', component: ArticleComponent },
  { path: 'home', component: HomeComponent },
  {path: '**', redirectTo: 'home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

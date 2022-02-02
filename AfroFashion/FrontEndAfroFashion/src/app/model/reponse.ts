import { Etape } from './etape';
export interface Reponse {
    id:number;
    isTrue:boolean;
    videoReponse:string;
    etape:Etape;
}

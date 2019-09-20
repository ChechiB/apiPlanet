import { Star } from './star';

export interface Planet{
    id:number;
    name:string;
    size:number;
    star: Star
}
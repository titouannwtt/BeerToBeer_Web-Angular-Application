import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Biere} from '../shared/biere';
import {Observable, throwError} from 'rxjs';
import {retry, catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})


export class RestApiService {

   apiUrl ='cerenity.net'

  constructor(private http: HttpClient) { }

  httpOptions ={
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  getBiere(): Observable<Biere> {
    return this.http.get<Biere>(this.apiUrl+'/biere')
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  createBiere(biere): Observable<Biere> {
    return this.http.post<Biere>(this.apiUrl + '/biere', JSON.stringify(biere), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  updateBiere(id, biere): Observable<Biere>{
    return this.http.put<Biere>(this.apiUrl + '/biere/' + id, JSON.stringify(biere), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  deleteBiere(id){
      return this.http.delete<Biere>(this.apiUrl + '/biere/' + id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
    }

  handleError(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
      } else {
        // Get server-side error
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
      }
      window.alert(errorMessage);
      return throwError(errorMessage);
    }







}

// station.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Station } from '../models/station/station.module';

@Injectable({
  providedIn: 'root'
})
export class StationService {
  private baseUrl = 'http://localhost:8080/api/stations';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  // GET: Retrieve all stations
  getStations(): Observable<Station[]> {
    return this.http.get<Station[]>(this.baseUrl);
  }

  // GET: Retrieve a single station by id
  getStation(id: number): Observable<Station> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Station>(url);
  }

  // POST: Create a new station
  createStation(station: Station): Observable<Station> {
    return this.http.post<Station>(this.baseUrl, station, this.httpOptions);
  }

  // PUT: Update an existing station
  updateStation(id: number, station: Station): Observable<any> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.put(url, station, this.httpOptions);
  }

  // DELETE: Remove a station
  deleteStation(id: number): Observable<Station> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<Station>(url, this.httpOptions);
  }
}

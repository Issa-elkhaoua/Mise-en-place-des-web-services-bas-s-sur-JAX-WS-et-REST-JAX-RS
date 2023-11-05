import { Component, OnInit } from '@angular/core';
import { StationService } from '../services/station.service';
import { Station } from '../models/station/station.module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-station',
  templateUrl: './station.component.html',
  styleUrls: ['./station.component.css']
})
export class StationComponent implements OnInit {
  stations!: Station[];
  stationForm!: FormGroup;
  currentStationId: number | null = null;

  constructor(
    private stationService: StationService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.stationForm = this.formBuilder.group({
      nom: ['', Validators.required],
      ville: ['', Validators.required],
      adresse: ['', Validators.required]
    });
    
    this.loadStations();
  }

  loadStations(): void {
    this.stationService.getStations().subscribe({
      next: (data) => this.stations = data,
      error: (err) => console.error(err),
    });
  }

  saveStation(): void {
    if (this.currentStationId === null) {
      this.stationService.createStation(this.stationForm.value).subscribe({
        next: () => this.loadStations(),
        error: (err) => console.error(err),
      });
    } else {
      this.stationService.updateStation(this.currentStationId, this.stationForm.value).subscribe({
        next: () => this.loadStations(),
        error: (err) => console.error(err),
      });
    }
    this.currentStationId = null;
    this.stationForm.reset();
  }

  editStation(station: Station): void {
    this.currentStationId = station.id;
    this.stationForm.patchValue(station);
  }

  deleteStation(id: number): void {
    this.stationService.deleteStation(id).subscribe({
      next: () => this.loadStations(),
      error: (err) => console.error(err),
    });
  }

  cancelEdit(): void {
    this.currentStationId = null;
    this.stationForm.reset();
  }}

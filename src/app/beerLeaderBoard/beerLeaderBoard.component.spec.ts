import { ComponentFixture, TestBed } from '@angular/core/testing';

import { beerLeaderBoardComponent } from './beerLeaderBoard.component';

describe('beerLeaderBoardComponent', () => {
  let component: beerLeaderBoardComponent;
  let fixture: ComponentFixture<beerLeaderBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ beerLeaderBoardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(beerLeaderBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

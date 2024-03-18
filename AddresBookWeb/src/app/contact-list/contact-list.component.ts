import { Component, OnInit, inject } from '@angular/core';
import { ContactService } from '../services/contact.service';
import { DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-contact-list',
  standalone: true,
  imports: [DatePipe, RouterModule],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css'
})
export default class ContactListComponent implements OnInit{
  private contactService = inject(ContactService);

  contacts: any[] = [];

  ngOnInit(): void {
    this.contactService.list()
      .subscribe((contacts: any) => {
          this.contacts = contacts;
            } )
  }
}

import { Component, OnInit, inject } from '@angular/core';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-contact-list',
  standalone: true,
  imports: [],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css'
})
export default class ContactListComponent implements OnInit{
  private contactService = inject(ContactService);

  ngOnInit(): void {
    this.contactService.list()
      .subscribe(contacts => {
        console.log(contacts);
      } )
  }
}

import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ContactService } from '../services/contact.service';
import { Contact } from '../model/contact.interfaces';

@Component({
  selector: 'app-contact-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './contact-form.component.html',
  styleUrl: './contact-form.component.css'
})
export default class ContactFormComponent implements OnInit{

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute)
  private contactService = inject(ContactService);


  form?: FormGroup;
  contact?: Contact;

  ngOnInit(): void {
      const id = this.route.snapshot.paramMap.get('id');

      if (id) {
        this.contactService.get(parseInt(id))
        .subscribe(contact => {
          this.contact = contact;
          this.form = this.fb.group({
            name: [contact.name, [Validators.required]],
            email: [contact.email, [Validators.required]],
          })
        })
      }else{
        this.form = this.fb.group({
          name: ['',[Validators.required]],
          email: ['', [Validators.required]],
        })
      }
    }

  save(){
    const contactForm = this.form!.value;

    if (this.contact){

    }
    this.contactService.create(contact)
      .subscribe(() =>{
        this.router.navigate(["/"])
      });
  }
}

import { Component, OnInit } from '@angular/core';
import { Clientes } from "../../models/cliente.model";
import { ClienteService } from 'src/app/services/cliente.services';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {
  clientes: Clientes[] = [];
  cliente: Clientes = {nome: '', email: ''}

  constructor(private clienteService: ClienteService){}

  ngOnInit(): void {
      this.listar();
  }

  listar(){
    this.clienteService.listar().subscribe((dados => this.clientes = dados));
  }

  salvar(){
    if(this.cliente.id){
      this.clienteService.editar(this.cliente).subscribe(() => {
      this.cliente = {nome: '', email: ''};
      this.listar();
    })
    }else {
      this.clienteService.cadastrar(this.cliente).subscribe(() => {
      this.cliente = {nome: '', email: ''};
      this.listar();
      })
    }
  }

  editar(cliente: Clientes){
    this.cliente = {...cliente}
  }

  excluir(id: number){
    this.clienteService.excluir(id).subscribe(() => {
      this.listar();
    }
    )
  }
}

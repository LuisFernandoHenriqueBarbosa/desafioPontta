import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";
import { Clientes } from "../models/cliente.model";

@Injectable({
  providedIn: 'root'
})

export class ClienteService{

  private url = `${environment.api}/cliente`

  constructor(private http: HttpClient){}

  listar(){
    return this.http.get<Clientes[]>(this.url)
  }

  cadastrar(cliente: Clientes){
    return this.http.post<Clientes>(this.url, cliente)
  }

  editar(cliente: Clientes){
    return this.http.put<Clientes>(`${this.url}/${cliente.id}`, cliente);
  }

  excluir(id: number){
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}

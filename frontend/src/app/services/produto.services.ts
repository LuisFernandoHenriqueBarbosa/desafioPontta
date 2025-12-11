import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";
import { Produtos } from "../models/produto.model";

@Injectable({
  providedIn: 'root'
})

export class ProdutoService{
  private url = `${environment.api}/produto`

  constructor(private http: HttpClient){}

  listar(){
    return this.http.get<Produtos[]>(this.url)
  }

  cadastrar(produto: Produtos){
    return this.http.post<Produtos>(this.url, produto)
  }

  editar(produto: Produtos){
    return this.http.put<Produtos>(`${this.url}/${produto.id}`, produto)
  }

  excluir(id: number){
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}

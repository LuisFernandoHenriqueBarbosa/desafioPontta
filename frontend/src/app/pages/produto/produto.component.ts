import { Component, OnInit } from '@angular/core';
import { Produtos } from 'src/app/models/produto.model';
import { ProdutoService } from 'src/app/services/produto.services';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {
    produtos: Produtos[] = [];
    produto: Produtos = {descricao: '', preco: 0}

    constructor(private produtoService: ProdutoService){}

    ngOnInit(): void {
        this.listar();
    }

    listar(){
        this.produtoService.listar().subscribe((dados => this.produtos = dados));
      }

      salvar(){
        if(this.produto.id){
          this.produtoService.editar(this.produto).subscribe(() => {
          this.produto = {descricao: '', preco: 0};
          this.listar();
        })
        }else {
          this.produtoService.cadastrar(this.produto).subscribe(() => {
          this.produto = {descricao: '', preco: 0};
          this.listar();
          })
        }
      }

      editar(produto: Produtos){
        this.produto = {...produto}
      }

      excluir(id: number){
        this.produtoService.excluir(id).subscribe(() => {
          this.listar();
        }
        )
      }

}

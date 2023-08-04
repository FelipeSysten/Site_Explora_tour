Algoritmo "cadastroagenciaviagem"
// Descrição   : Bem vindo(a) a agência de viagem!
// Autor(a)    : Felipe de Souza Alves
// Data atual  : 04/08/2023
Var


   clienteCadastro, cadastroDestino, clienteTel: vetor [1..3] de caractere
   i , opcao, clientes, destinos: inteiro


Inicio

   clientes <- 0
   destinos <- 0


   escreval("****** BEM VINDO A EXPLORA TOUR  ****** ")


   repita
      escreval(" DIGITE 1: Para cadastrar o cliente e destino")
      escreval(" DIGITE 2: Para consultar o cliente e destino")
      escreval(" DIGITE 3: Para Sair")
      leia(opcao)

      escolha(opcao)
      caso 1
         se clientes < 3 entao
            escreval("Qual o seu nome completo? ")
            leia(clienteCadastro[clientes+1])
            escreval("Telefone para Contato: ")
            leia(clienteTel[clientes+1])
            escreval("Destino do Cliente: ")
            leia(cadastroDestino[destinos+1])

            clientes <- clientes + 1
            destinos <- destinos + 1
            escreval("Cadastrado com sucesso!")
         senao
            escreval("Limite máximo de clientes atingido. Cadastro não realizado.")
         fimse

         limpatela
      caso 2
         se clientes = 0 entao
            escreval("Não há cliente cadastrado")
         senao
            para i de 1 ate clientes faca
               escreval ("Nome do cliente: " , clienteCadastro[i])
               escreval ("Telefone do cliente: " , clienteTel[i])
               escreval ("Destino do cliente: " , cadastroDestino[i])
            fimpara
         fimse

      caso 3
          escreval("========== VOLTE SEMPRE ==========")
          escreval("********** EXPLORE TOUR **********")
         interrompa
      outrocaso
         escreval("Opção inválida")
      fimEscolha



   ate opcao = 3


Fimalgoritmo
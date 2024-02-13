# agendix

### Designação dos pacotes e arquitetura
```
|--controller - armazena as controllers dos endpoints da API REST
|--configuration - armazena classes de configuração necessárias ao iniciar a aplicação
|--domain - armazena as classes que trabalham com as regras de negócio da aplicação bem como comunicação com API externas que estão associadas a essas regras
	|__client - armazena as classes de comunicação com serviços e APIs externas
	|__facade - é uma interface de acesso ao serviços, sabe pra onde mandar uma informação, quem são os parceiros externos que precisam receber esses dados ou que podem fornecer esses dados para a operação do mesmo, vão sempre se preocupar em como os dados recebidos estão e sua integridade para o fluxo bem como adequá-los para serem devolvidos ou passados para a proxima camada, manipula services e clients
	|__service - armazena as classes de gerenciamento dos dados, não se preocupa em como os dados chegam ou vão, mas sim em utilizá-los, só manipula entities e repositories
|--model - armazena as estruturas do modelo de dados da aplicação
	|__dto - são representações dos dados, são os objetos recebidos e devolvidos pelas facades e controllers
	|__entity - são as representações dos próprios objetos do banco de dados ou do negócio, tem esse como seu único objetivo não servem para comunicação ou outras utilizações que fogem da camada de repository e e service 
	|__repository - servem como interface de acesso aos dados, só gerenciam as operações com os dados oriundos da entities que ele recebe
```

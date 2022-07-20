#Aplicação para verificar quantas vezes se repete o parametro passado para api


#Docker
- entrar na pasta do projeto
- executar o comando "docker build -f Dockerfile -t words-api ."
- logo em sequencia após terminar o passo anterior, executar o seguinte comando "docker run -p 8080:8080 words-api"


#API
- rodando em um host local, para acessar a api o endereco deve ser acessado "localhost:8080/words/ " sendo que o parametro sera passado após a ultima /, como por exemplo, quero buscar quantas vezes a palavra teste se repete então digite "localhost:8080/b2w/words/teste" 

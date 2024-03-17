# Previsão do Tempo

O aplicativo Previsão do Tempo permite aos usuários obter informações meteorológicas atualizadas para diferentes cidades em todo o mundo. Ele exibe dados como temperatura atual, umidade, sensação térmica e índice UV.

## Instalação

Para instalar o aplicativo, siga estas etapas:

1. Clone o repositório para o seu computador local:
```plaintext
git clone https://github.com/seu-usuario/previsao-do-tempo.git
```

2. Abra o projeto em seu ambiente de desenvolvimento preferido (por exemplo, Android Studio).

3. Compile e execute o aplicativo em um dispositivo ou emulador Android.

## Como Usar

Após iniciar o aplicativo, você será recebido com uma interface simples e intuitiva. Aqui está como você pode usar o aplicativo:

1. Digite o nome da cidade na caixa de pesquisa e clique no ícone de busca.
2. O aplicativo buscará informações meteorológicas para a cidade especificada e exibirá os resultados na tela.
3. Você pode rolar para baixo para ver detalhes adicionais, como temperatura, umidade, sensação térmica e índice UV.
4. Para obter informações de outras cidades, repita o processo de pesquisa.

## Dependências

Este aplicativo depende de várias bibliotecas e serviços:

- [Retrofit](https://square.github.io/retrofit/): Uma biblioteca para interagir com APIs REST.
- [Gson](https://github.com/google/gson): Uma biblioteca para serialização/desserialização de objetos Java em JSON.
- [Material Components for Android](https://material.io/develop/android): Componentes de interface do usuário baseados no Material Design.

## Contribuição

Contribuições são bem-vindas! Se você deseja contribuir para este projeto, por favor, siga estas etapas:

1. Faça um fork do repositório.
2. Crie uma branch para a sua feature (`git checkout -b feature/MinhaFeature`).
3. Faça commit das suas alterações (`git commit -am 'Adiciona minha feature'`).
4. Faça push para a branch (`git push origin feature/MinhaFeature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a [Ainda não decidi](https://).

## Contato

Para mais informações ou suporte, entre em contato com [seu-email@example.com](mailto:seu-email@example.com).

## Recursos de Strings

Neste aplicativo, alguns textos são definidos em arquivos XML de recursos. Aqui estão os recursos de strings utilizados:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>

    <!-- Nome do aplicativo -->
    <string name="app_name">Previsão do Tempo</string>
    
    <!-- Texto para a caixa de pesquisa -->
    <string name="pesquisa">Pesquise cidade aqui</string>
    
    <!-- Texto para a umidade -->
    <string name="umidade">Humidity</string>
    
    <!-- Texto para a sensação térmica -->
    <string name="sense_termica">Sens. Térmica</string>
    
    <!-- Texto para a temperatura máxima -->
    <string name="temp_max">Temp. Máx</string>
    
    <!-- Texto para o índice UV -->
    <string name="uv">UV</string>
    
</resources>

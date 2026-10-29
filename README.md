<div align="center">

# ✦ Bíblia Literal

### Um espaço leve para ler, pesquisar e estudar as Escrituras.

**Mobile-first · PWA · Funciona também em tablets e computadores**

[Abrir projeto no GitHub](https://github.com/Icristolfe/biblia-literal) · [Ver créditos e licenças](CRÉDITOS.md)

</div>

---

## Sobre o projeto

A **Bíblia Literal** é um leitor bíblico independente, feito para facilitar a leitura em diferentes telas. Ele abre em **Gênesis 1**, na versão **PT-BR**. No celular, segue o visual do app Android: fundo preto, detalhes em azul `#072246`, navegação compacta e controles de capítulo fixos na parte inferior. A interface adapta-se a tablets e computadores e pode ser instalada como aplicativo pelo navegador. Depois do primeiro carregamento online, o site tenta manter o conteúdo disponível para leitura offline.

Na tradução literal, a pronúncia aproximada do texto original aparece agrupada acima das frases correspondentes em português. O agrupamento ajuda a acompanhar a leitura; como o corpus não traz alinhamento palavra a palavra, a correspondência é aproximada.

## O que você encontra

- **Leitura responsiva:** experiência adaptada para celular, tablet e computador.
- **Navegação bíblica:** escolha um livro e capítulo ou avance e volte entre capítulos.
- **Busca:** pesquise palavras e expressões nos textos disponíveis.
- **Duas versões para leitura:** PT-BR e Literal, incluindo pronúncia transliterada do texto original.
- **Detalhes por versículo:** no Literal, o toque mostra apenas as referências; no PT-BR, mostra o literal com a pronúncia agrupada por frase e ligada por uma chave.
- **Estudo do original:** veja o texto original e a pronúncia aproximada junto à tradução literal.
- **PWA e leitura offline:** instale pelo navegador e acesse conteúdo em cache após carregar online.
- **Sem servidor de aplicação:** site estático, sem banco de dados, Python ou configuração de backend.

## Publicar no Netlify

Este repositório já é o projeto web independente. Importe-o no Netlify e use estas configurações:

| Configuração | Valor |
| --- | --- |
| Diretório base | deixe em branco (raiz do repositório) |
| Comando de build | deixe em branco |
| Diretório de publicação | `.` |

O arquivo `netlify.toml` já define a pasta de publicação e as regras necessárias. Não é preciso compilar o app Android nem instalar dependências.

## Executar localmente

Com Python instalado, inicie um servidor estático na pasta do projeto:

```powershell
py -3 -m http.server 8000
```

Abra [http://localhost:8000](http://localhost:8000). A execução por `localhost` também permite testar recursos PWA, como o service worker.

## Estrutura

```text
netlify-app/
├── index.html                 # página do leitor
├── netlify.toml                # configuração de publicação
├── service-worker.js           # cache para uso offline
└── static/
    ├── content/bible-data.js   # textos bíblicos incluídos (~31 MB)
    ├── reader.css              # estilos responsivos
    ├── reader.js               # navegação, busca e leitura
    ├── icon.svg                # ícone do site
    └── manifest.webmanifest    # instalação como PWA
```

## Conteúdo e licenças

As traduções têm fontes e licenças diferentes. Consulte [CRÉDITOS.md](CRÉDITOS.md) antes de redistribuir ou adaptar o conteúdo. A pronúncia e o agrupamento visual são recursos de estudo, não uma análise linguística palavra a palavra.

---

<div align="center">

Feito para uma leitura clara, em qualquer tela. ✦

</div>

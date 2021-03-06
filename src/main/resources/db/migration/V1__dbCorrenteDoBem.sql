-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Jul-2021 às 21:42
-- Versão do servidor: 10.4.19-MariaDB
-- versão do PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeto_cp5a`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `city` varchar(150) NOT NULL,
  `state` varchar(50) NOT NULL,
  `street` varchar(150) NOT NULL,
  `address_number` varchar(10) NOT NULL,
  `complement` varchar(50) DEFAULT NULL,
  `neighborhood` varchar(200) NOT NULL,
  `zip_code` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `address`
--

INSERT INTO `address` (`id`, `city`, `state`, `street`, `address_number`, `complement`, `neighborhood`, `zip_code`) VALUES
(1, 'São Paulo', 'SP', 'R. Paim', '394', NULL, 'Bela Vista', '01306010'),
(2, 'Salvador', 'BA', 'R. Beijaflor', '234', NULL, 'Pássaros', '23345039');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cause`
--

CREATE TABLE `cause` (
  `id` int(11) NOT NULL,
  `label` varchar(60) NOT NULL,
  `value` varchar(60) NOT NULL,
  `img` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cause`
--

INSERT INTO `cause` (`id`, `label`, `value`, `img`) VALUES
(1, 'saude', 'Saúde', 'images/health_cause.svg'),
(2, 'Meio ambiente', 'Meio Ambiente', 'images/environment_cause.svg'),
(3, 'mulheres', 'Mulheres', 'images/women_cause.svg'),
(4, 'arte e cultura', 'Arte e Cultura', 'images/art_cause.svg'),
(5, 'Educacao', 'Educação', 'images/education_cause.svg'),
(6, 'Direitos Humanos', 'Direitos Humanos', 'images/human_right_cause.svg'),
(7, 'Crianças', 'Crianças', 'images/children_cause.svg'),
(8, 'Idosos', 'Idosos', 'images/eldery_cause.svg'),
(9, 'Protecao animal', 'Proteção animal', 'images/animal_cause.svg'),
(10, 'Diversidade', 'Diversidade', 'images/diversity_cause.svg');

-- --------------------------------------------------------

--
-- Estrutura da tabela `hability`
--

CREATE TABLE `hability` (
  `id` int(11) NOT NULL,
  `label` varchar(60) NOT NULL,
  `value` varchar(60) NOT NULL,
  `img` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `hability`
--

INSERT INTO `hability` (`id`, `label`, `value`, `img`) VALUES
(1, 'Educacao', 'Educação', 'images/teacher.svg'),
(2, 'Danca', 'Dança', 'images/workout.svg'),
(3, 'Malhacao', 'Malhação', 'images/personal.svg'),
(4, 'Musica', 'Música', 'images/music.svg'),
(5, 'Meditacao', 'Meditação', 'images/meditation.svg'),
(6, 'Medicina', 'Medicina', 'images/medical_care.svg'),
(7, 'conservacao', 'Conservação Ambiental', 'images/ecological_cause.svg'),
(8, 'Programacao', 'Programação', 'images/dev.svg'),
(9, 'Culinaria', 'Culinária', 'images/cooking.svg'),
(10, 'Barbearia', 'Barbearia', 'images/barber.svg'),
(11, 'Esportes', 'Esportes', 'images/sports.svg'),
(12, 'Artes', 'Artes', 'images/artist.svg');

-- --------------------------------------------------------

--
-- Estrutura da tabela `institution`
--

CREATE TABLE `institution` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `img` varchar(200) DEFAULT NULL,
  `email` varchar(150) NOT NULL,
  `summary` varchar(50) DEFAULT NULL,
  `cnpj` varchar(14) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `site` varchar(150) DEFAULT NULL,
  `facebook` varchar(150) DEFAULT NULL,
  `instagram` varchar(150) DEFAULT NULL,
  `bio` varchar(1000) NOT NULL,
  `address_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `institution`
--

INSERT INTO `institution` (`id`, `name`, `img`, `email`, `summary`, `cnpj`, `phone`, `site`, `facebook`, `instagram`, `bio`, `address_id`) VALUES
(1, 'Associação Médicos do Mundo', 'https://www.netfarma.pt/wp-content/uploads/2018/05/8712a16162a96f343da428940d44b49c.jpg', 'medicos@medicos.com', 'Somos médicos do mundo', '6,52E+13', '99999999999', 'https://medicospelavidacovid19.com.br/', 'https://www.facebook.com/medicojovem', 'https://www.instagram.com/medicospelavidacovid19/', 'No final de 2015, inspirado pelo médico americano Dr. Jim Withers - um dos precursores da medicina de rua - o médico neurologista e professor Dr. Mário Guimarães, começou a atender a população em situação de rua e vulnerabilidade na cidade de são Paulo. Inicialmente sozinho, aos poucos passou a ser acompanhado por seus alunos de medicina. Dr Mário decidiu realizar esta ação ao observar o número crescente de pessoas desabrigadas em seu trajeto do metrô ao trabalho.', 2),
(2, 'Iracambi Research Center', 'https://iracambi.com/wp-content/uploads/23.-iracambi-redondo.jpg', 'ambiente@ambiente.com', 'Somos médicos do mundo', '6,52E+13', '99999999999', 'www.medicos.com.br', 'null', '@medicos-mundo', 'No final de 2015, inspirado pelo médico americano Dr. Jim Withers - um dos precursores da medicina de rua - o médico neurologista e professor Dr. Mário Guimarães, começou a atender a população em situação de rua e vulnerabilidade na cidade de são Paulo. Inicialmente sozinho, aos poucos passou a ser acompanhado por seus alunos de medicina. Dr Mário decidiu realizar esta ação ao observar o número crescente de pessoas desabrigadas em seu trajeto do metrô ao trabalho.', 2),
(3, 'Ospália coletivo de palhaços', 'https://s2.glbimg.com/kh0dTZ-G_LUKFXJkGT6f7MR4Lf8=/0x0:1280x960/1008x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2020/Z/N/Y3B7cESXyLdQmMDiVG', 'palhaco@palhaco.com', 'Somos palhaços', '6,52E+13', '99999999999', 'www.palhacos.com.br', 'null', '@palhaco', 'Somos um grupos de palhaços que visitamos semanalmente hospitais e asilos na grande Belo Horizonte. Levamos a arte, a cultura e o nosso amor para transformar ambientes através da arte do palhaço. Atuamos em hospitais, asilos e em trabalhos sociais e nas ruas.', 2),
(4, 'Ensinaê', 'https://storage.googleapis.com/atados-v3/user-uploaded/images-medium/29b700a2-9988-4472-8495-02f7d46ea03d.jpeg', 'ensina@ensina.com', 'Somos profs', '6,52E+13', '99999999999', 'www.profs.com.br', 'null', '@profs', 'O projeto se iniciou como um grupo de estudos entre amigos. Com o passar das reuniões pensamos que poderíamos apoiar outras pessoas que estão na mesma situação que a gente, desesperados e não sabendo nada para o ENEM. Então criamos o projeto voltado para alunos que tem dificuldade em matemática ou até mesmo que queiram estudar conteúdos mais voltados para os vestibulares. O projeto ainda esta iniciando, mas pretendemos apoiar todos que queiram participar, tanto como aluno ou professor.', 2),
(5, 'Amigos e bichos', 'https://storage.googleapis.com/atados-v3/user-uploaded/images-medium/89cfe820-f516-4876-bf0f-d67ad7f7a129.jpg', 'animais@animais.com', 'Resgatamos animais vitimas de maus tratos e abando', '6,52E+13', '99999999999', 'www.animais.com.br', 'null', '@animais', 'Fazemos o trabalho com animais sem recursos ou ajuda de qualquer instituição. A ajuda que conseguimos é de amigos e simpatizantes da causa animal. Temos hoje cerca de 70 animais precisando de um lar!', 2),
(6, 'Dentistas Unidos', 'https://ituemdestaque.com.br/wp-content/uploads/2016/04/dentista-do-bem1-680x365_c.png', 'dentistas@dentistas.com', 'Atendemos pacientes que não têm acesso a cuidados ', '6,52E+13', '99999999999', 'www.dentistas.com.br', 'null', '@dentistas', 'Criado em julho de 2007 por iniciativa da dentista Marisa Helena de Carvalho, motivada pelo seu histórico de enfrentamento do câncer e da médica oncologista Vanessa de Carvalho Fabrício e vem atendendo um número grande de pacientes que não têm acesso a cuidados bucais adequados. Nosso Instituto disponibiliza tratamentos odontológicos completos, especialmente para a mucosite bucal, exclusivamente à pacientes de baixa renda (crianças, adolescentes, adultos e idosos) em tratamento quimioterápico e/ou radioterápico, por conseqüência de algum tipo de câncer e pacientes com necessidades especias, sendo estes, com deficiências, doenças sistêmicas, doenças infectocontagiosas, alterações comportamentais e temporais.', 2),
(7, 'Projeto Zambelê', 'https://storage.googleapis.com/atados-v3/project/associacao-amigos-e-3a-idade-esperanca-monte-azul/danca-para-3a-idade.png', 'zambele@zambele.com', 'Viver bem é fazer boas trocas! Aqui trocamos alegr', '6,52E+13', '99999999999', 'www.dentistas.com.br', 'null', '@dentistas', 'Lá você pode encontrar: aulas de Ginástica, Musculação, Hidroginástica e Dança Sênior como nossas atividades principais. Também realizamos festas, passeios, encontros para trocas de saberes e promovemos cursos. Além dos idosos atendidos nos espaços destinados às atividades, a Raízes da Vida vai também até os locais onde idosos se encontram, pois existem também grupos atendidos pela organização em Instituições de longa permanência.', 2),
(8, 'Violeiros da Esperança', 'https://storage.googleapis.com/atados-v3/nonprofit/harmonicanto_medium.jpg', 'violeiros@violeiros.com', 'Música e Cidadania. Associação no Cantagalo que de', '6,52E+13', '99999999999', 'www.violeiros.com.br', 'null', '@violeiros', 'A Violeiros da Esperança visa proporcionar o desenvolvimento integral a crianças, adolescentes e jovens por meio de ações socioeducativas, culturais e esportivas. Queremos dar oportunidades para que as crianças se desenvolvam por meio da música, com a participação da família e da comunidade.', 2),
(9, 'Cozinhando Amor', 'https://storage.googleapis.com/atados-v3/project/associacao-a-gente-ajuda/cozinhe-para-quem-precisa.jpg', 'cozinhando@cozinhando.com', 'Cozinhamos com amor para aqueles que necessitam.', '6,52E+13', '99999999999', 'www.cozinhando.com.br', 'null', '@cozinhando', 'Cozinhamos com amor para aqueles que necessitam.', 2),
(10, 'SurfSolidário', 'https://static.wixstatic.com/media/3aab0b_60d7235f779549e7ac594e142a84b4ec~mv2.png/v1/fill/w_220,h_268,al_c,q_85,usm_0.66_1.00_0.01/Logo%20Vida%26Surf_Principal.webp', 'surf@surf.com', 'Promovemos o desenvolvimento integral de crianças', '6,52E+13', '99999999999', 'www.surf.com.br', 'null', '@surf', 'O Projeto SurfSolidário surgiu do sonho do surfista Jojó de Olivença, Bicampeão Brasileiro de Surf. Após deixar o Circuito Internacional de Surf, Jojó criou uma escola de surf na Praia da Enseada, Guarujá - SP, o projeto cresceu e, além das aulas de surf, começaram a oferecer também suporte no aprendizado de português e matemática, educação ambiental e as palestras sobre valores. Aos poucos as famílias das crianças foram se aproximando, buscando orientações e ampliação de visão de mundo também.', 2),
(11, 'Grafite Livre', 'https://storage.googleapis.com/atados-v3/user-uploaded/images/40fc5c07-dc39-464f-a161-c3eb80ba2b61.png', 'grafite@grafite.com', 'Somos um coletivo de moradores da zona sul que dec', '6,52E+13', '99999999999', 'www.grafite.com.br', 'null', '@grafite', 'Iniciado em setembro de 2012, o Revitarte é um coletivo composto por jovens moradores do Jardim Monte Azul, Parque Arariba e Jardim São Luís que tem por objetivo revitalizar espaços degradados através da arte e trabalho coletivo. Além das revitalizações, registramos o processo de transformação em foto e vídeo. Pretendemos revitalizar o maior número de espaços, levar diversas culturas para os ambientes e mostrar que é nosso dever como cidadãos ocupar espaços públicos.Nossa primeira ação foi realizada despretensiosamente em setembro de 2012 e durou dois finais de semana.Reunimos 3 amigos graffiteiros e com apoio de cerca de 50 pessoas (entre amigos e moradores do bairro) revitalizamos a fachada e as laterais da casa, na qual morava uma dependente química que vivia em más condições.Em junho de 2013 fomos contemplados com o 7º Prêmio Criando Asas e conseguimos dar continuidade no projeto revitalizando um escadão do bairro Jardim Monte Azul. Foram convidados 11 graffiteiros para fazer as pa', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `institution_cause`
--

CREATE TABLE `institution_cause` (
  `id` int(11) NOT NULL,
  `institution_id` int(11) NOT NULL,
  `cause_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `institution_cause`
--

INSERT INTO `institution_cause` (`id`, `institution_id`, `cause_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 1),
(4, 4, 5),
(5, 5, 9),
(6, 6, 1),
(7, 7, 1),
(8, 8, 3),
(9, 9, 6),
(10, 10, 7),
(11, 11, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `title` varchar(60) NOT NULL,
  `img` varchar(150) NOT NULL,
  `local_type` varchar(150) NOT NULL,
  `institution_id` int(11) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `popularity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `project`
--

INSERT INTO `project` (`id`, `status`, `title`, `img`, `local_type`, `institution_id`, `description`, `popularity`) VALUES
(1, 1, 'FullStack para WebSite', 'http://clubedosgeeks.com.br/wp-content/uploads/2016/04/FullStack-Image.jpg', 'remoto', 1, 'Precisamos de um desenvolvedor Front e Back, que venha integrar nosso time e redesenhar nosso site e criar o portal do(a) voluntário(a), irá atuar com MKT e RH.', 40),
(2, 1, 'Conservação da Mata Atlântica', 'https://aconteceunovale.com.br/portal/wp-content/uploads/2015/08/parque_serra_do_brigadeiro_1.jpg', 'local', 2, 'Buscamos voluntários(as) para apoiar em nossos projetos de conservação da Mata Atlântica no Sul da Serra do Brigadeiro, MG.', 30),
(3, 1, 'Palhaços(as) Voluntários(as)', 'https://www.doutoresdaalegria.org.br/wp-content/uploads/2013/12/de-quem-e-o-pai-1.jpg', 'local', 3, 'Precisamos de palhaços/as voluntários, iniciado na palhaçaria e que toquem instrumentos harmônicos, para atuar em hospitais, asilos, comunidades e etc', 50),
(4, 1, 'Professor(a) de Matemática', 'https://image.freepik.com/free-psd/math-teacher-showing-formulas-board_23-2148272785.jpg', 'remoto', 4, 'Buscamos voluntários(as) que desejam dar aulas para jovens que procuram apoio na área de matemática, voltada para vestibulares e ENEM. Vamos juntos!', 10),
(5, 1, 'Digital Influencer', 'https://blog.depositphotos.com/wp-content/uploads/2020/01/Make-Your-Pet-Instagram-Famous-With-These-7-Tips-2.jpg', 'remoto', 5, 'Estamos precisando de alguém com experiência em redes sociais para gerar mais engajamento e apoio para nossa ONG.', 80),
(6, 2, 'Dentista(o)', 'https://images.unsplash.com/photo-1588776814546-1ffcf47267a5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1', 'local', 6, 'Estamos precisando de alguém com experiência em periodontia.', 40),
(7, 1, 'Instrutor(a) de Academia', 'https://images.unsplash.com/photo-1517836357463-d25dfeac3438?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1', 'local', 7, 'Buscamos voluntários(as) que desejam dar aulas para idosos que precisam de exercícios para controle da saúde!', 30),
(8, 1, 'Professor(a) de Música', 'https://images.unsplash.com/photo-1524650359799-842906ca1c06?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=8', 'local', 8, 'Projeto para o ensino de flauta doce, canto, canto coral, teoria musical, teclado e violão.', 45),
(9, 1, 'Médicas(os)', 'https://images.unsplash.com/photo-1551601651-2a8555f1a136?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=772&', 'local', 1, 'Precisamos de médicos voluntários para a linha de frente do Covid-19', 90),
(10, 2, 'Cozinheiro(a)', 'https://images.unsplash.com/photo-1507048331197-7d4ac70811cf?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1', 'local', 9, 'Buscamos voluntários(as) que desejam dar aulas para jovens que procuram apoio na área de matemática, voltada para vestibulares e ENEM. Vamos juntos!', 60),
(11, 1, 'Professor(a) de Surf', 'https://images.unsplash.com/photo-1601387271717-b57efaabad61?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1', 'local', 10, 'Aloha! Fazemos uma vez por mês a ação Praia Limpa e Boas Ondas, na Praia da Enseada, Guarujá. Os resíduos viram pranchas de surf e outros produtos!', 11),
(12, 1, 'Grafiteira', 'https://images.unsplash.com/photo-1491225063580-7e097e87dcb2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1', 'remoto', 11, 'Iremos fazer quatro espaços e precisamos da sua ajuda para tirar o projeto do papel e ganhar cor na rua. Nós iremos garantir todo material básico, como tintas e rolos... só precisamos da sua vontade em nos ajudar. Topa? Prometemos que será divertido e compensador para o coração.', 90);

-- --------------------------------------------------------

--
-- Estrutura da tabela `project_cause`
--

CREATE TABLE `project_cause` (
  `id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `cause_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `project_cause`
--

INSERT INTO `project_cause` (`id`, `project_id`, `cause_id`) VALUES
(1, 1, 8),
(2, 2, 2),
(3, 3, 1),
(4, 4, 5),
(5, 5, 9),
(6, 6, 1),
(7, 7, 1),
(8, 8, 3),
(9, 9, 1),
(10, 10, 6),
(11, 11, 7),
(12, 12, 4),
(13, 1, 2),
(14, 1, 1),
(15, 3, 7),
(16, 3, 8),
(17, 7, 8),
(18, 8, 4),
(19, 8, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `project_hability`
--

CREATE TABLE `project_hability` (
  `id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `hability_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `project_hability`
--

INSERT INTO `project_hability` (`id`, `project_id`, `hability_id`) VALUES
(1, 1, 8),
(2, 2, 7),
(3, 3, 4),
(4, 4, 1),
(5, 5, 8),
(6, 6, 2),
(7, 7, 2),
(8, 8, 4),
(9, 9, 6),
(10, 10, 9),
(11, 11, 11),
(12, 12, 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `subscription`
--

CREATE TABLE `subscription` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `subscription`
--

INSERT INTO `subscription` (`id`, `user_id`, `project_id`, `date`, `status`) VALUES
(1, 1, 1, '2021-07-07', 'Cancelada'),
(2, 1, 3, '2021-07-07', 'Aceita'),
(3, 2, 5, '2021-07-07', 'Recusada'),
(4, 2, 3, '2021-07-07', 'Pendente'),
(5, 2, 1, '2021-07-07', 'Cancelada'),
(6, 3, 1, '2021-07-07', 'Aceita');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `img` varchar(500) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `birth_date` date NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(150) NOT NULL,
  `address_id` int(11) NOT NULL,
  `institution_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`id`, `type`, `name`, `img`, `cpf`, `birth_date`, `phone`, `email`, `address_id`, `institution_id`) VALUES
(1, 1, 'João Francisco', 'https://images.generated.photos/F1kxr3TrJUtSpjC9N3jfcWsTMEx7RvAuAHkJwWyaGCo/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zL3Yz/XzA1OTczODYuanBn.jpg', '55555555555', '2001-07-11', '(75) 9 9166-3952', 'joao@joao.com', 1, NULL),
(2, 1, 'Maria de Andrade', 'https://images.generated.photos/J_Gbcl-lngf5B7taH6d5MCA8s64uJQr7XGmTJIPYhoQ/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zL3Yz/XzAzMDc2MDguanBn.jpg', '55555555555', '2001-07-11', '99999999999', 'maria@maria.com', 1, NULL),
(3, 1, 'Joana Dark', 'https://images.generated.photos/rJd3R3BRwCiELbXbxPSDKsxhGEF3SJqAQuaIxmqkxAI/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zL3Yz/XzA1OTU4ODIuanBn.jpg', '55555555555', '2001-07-11', '99999999999', 'joana@joana.com', 1, NULL),
(4, 2, 'Associação Médicos do Mundo', 'https://www.netfarma.pt/wp-content/uploads/2018/05/8712a16162a96f343da428940d44b49c.jpg', '', '0000-00-00', 'null', 'medicos@medicos.com', 1, 1),
(5, 2, 'Iracambi Research Center', 'https://www.medicosdomundo.org.br/wp-content/uploads/2019/08/M%C3%A9dicos-do-Mundo-Logo-Principal-2-300x137.png', '', '0000-00-00', 'null', 'ambiente@ambiente.com', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_cause`
--

CREATE TABLE `user_cause` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `cause_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `user_cause`
--

INSERT INTO `user_cause` (`id`, `user_id`, `cause_id`) VALUES
(1, 1, 2),
(2, 1, 4),
(3, 1, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_hability`
--

CREATE TABLE `user_hability` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `hability_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `user_hability`
--

INSERT INTO `user_hability` (`id`, `user_id`, `hability_id`) VALUES
(1, 1, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `cause`
--
ALTER TABLE `cause`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `hability`
--
ALTER TABLE `hability`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `institution`
--
ALTER TABLE `institution`
  ADD PRIMARY KEY (`id`),
  ADD KEY `address_id` (`address_id`);

--
-- Índices para tabela `institution_cause`
--
ALTER TABLE `institution_cause`
  ADD PRIMARY KEY (`id`),
  ADD KEY `institution_id` (`institution_id`),
  ADD KEY `cause_id` (`cause_id`);

--
-- Índices para tabela `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD KEY `institution_id` (`institution_id`);

--
-- Índices para tabela `project_cause`
--
ALTER TABLE `project_cause`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cause_id` (`cause_id`),
  ADD KEY `project_id` (`project_id`);

--
-- Índices para tabela `project_hability`
--
ALTER TABLE `project_hability`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hability_id` (`hability_id`),
  ADD KEY `project_id` (`project_id`);

--
-- Índices para tabela `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `project_id` (`project_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Índices para tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `institution_id` (`institution_id`),
  ADD KEY `address_id` (`address_id`);

--
-- Índices para tabela `user_cause`
--
ALTER TABLE `user_cause`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cause_id` (`cause_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Índices para tabela `user_hability`
--
ALTER TABLE `user_hability`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hability_id` (`hability_id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `cause`
--
ALTER TABLE `cause`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `hability`
--
ALTER TABLE `hability`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `institution`
--
ALTER TABLE `institution`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `institution_cause`
--
ALTER TABLE `institution_cause`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `project_cause`
--
ALTER TABLE `project_cause`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `project_hability`
--
ALTER TABLE `project_hability`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `subscription`
--
ALTER TABLE `subscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `user_cause`
--
ALTER TABLE `user_cause`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `user_hability`
--
ALTER TABLE `user_hability`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `institution`
--
ALTER TABLE `institution`
  ADD CONSTRAINT `institution_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`);

--
-- Limitadores para a tabela `institution_cause`
--
ALTER TABLE `institution_cause`
  ADD CONSTRAINT `institution_cause_ibfk_1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`),
  ADD CONSTRAINT `institution_cause_ibfk_2` FOREIGN KEY (`cause_id`) REFERENCES `cause` (`id`);

--
-- Limitadores para a tabela `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`);

--
-- Limitadores para a tabela `project_cause`
--
ALTER TABLE `project_cause`
  ADD CONSTRAINT `project_cause_ibfk_1` FOREIGN KEY (`cause_id`) REFERENCES `cause` (`id`),
  ADD CONSTRAINT `project_cause_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

--
-- Limitadores para a tabela `project_hability`
--
ALTER TABLE `project_hability`
  ADD CONSTRAINT `project_hability_ibfk_1` FOREIGN KEY (`hability_id`) REFERENCES `hability` (`id`),
  ADD CONSTRAINT `project_hability_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

--
-- Limitadores para a tabela `subscription`
--
ALTER TABLE `subscription`
  ADD CONSTRAINT `subscription_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  ADD CONSTRAINT `subscription_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Limitadores para a tabela `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_3` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`),
  ADD CONSTRAINT `user_ibfk_4` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`);

--
-- Limitadores para a tabela `user_cause`
--
ALTER TABLE `user_cause`
  ADD CONSTRAINT `user_cause_ibfk_1` FOREIGN KEY (`cause_id`) REFERENCES `cause` (`id`),
  ADD CONSTRAINT `user_cause_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Limitadores para a tabela `user_hability`
--
ALTER TABLE `user_hability`
  ADD CONSTRAINT `user_hability_ibfk_1` FOREIGN KEY (`hability_id`) REFERENCES `hability` (`id`),
  ADD CONSTRAINT `user_hability_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

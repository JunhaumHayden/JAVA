package main;

import java.time.LocalDate;

import domain.alunos.Dev;
import domain.conteudos.Bootcamp;
import domain.conteudos.Curso;
import domain.conteudos.Mentoria;

public class Main 
{
    public static void main(String[] args) 
    {
        Curso curso01 = new Curso();
        curso01.setTitulo("Curso Java");
        curso01.setDescricao("Descrição do Curso de Java");
        curso01.setCargaHoraria(8);

        Curso curso02 = new Curso();
        curso02.setTitulo("Curso Python");
        curso02.setDescricao("Descrição do Curso de Python");
        curso02.setCargaHoraria(4);
        
        Mentoria mentoria01 = new Mentoria();
        mentoria01.setTitulo("Mentaoria Java");
        mentoria01.setDescricao("Descrição da mentoria do curso de Java");
        mentoria01.setData(LocalDate.now());

        /*System.out.println(curso01);
        System.out.println(curso02);
        System.out.println(mentoria01);*/     
        
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso01);
        bootcamp.getConteudos().add(curso02);
        bootcamp.getConteudos().add(mentoria01);

        Dev devAna = new Dev();
        devAna.setNome("ANA");
        devAna.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos ANA:" + devAna.getConteudosInscritos());
        devAna.progredir();
        devAna.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos ANA:" + devAna.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos ANA:" + devAna.getConteudosConcluidos());
        System.out.println("XP:" + devAna.calcularTotalXp());

        System.out.println("-------");

        Dev devBia = new Dev();
        devBia.setNome("Bia");
        devBia.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos BIA:" + devBia.getConteudosInscritos());
        devBia.progredir();
        devBia.progredir();
        devBia.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos BIA:" + devBia.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos BIA:" + devBia.getConteudosConcluidos());
        System.out.println("XP:" + devBia.calcularTotalXp());
    }
}

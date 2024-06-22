package Vacina.model;

import java.time.LocalDate;

public class Historico {



        private String nomeIdoso;
        private String nomeVacina;
        private LocalDate dataAplicacao;
        private String nomeAgente;

        public Historico (String nomeIdoso, String nomeVacina, LocalDate dataAplicacao, String nomeAgente){
            this.nomeIdoso = nomeIdoso;
            this.nomeVacina = nomeVacina;
            this.dataAplicacao= dataAplicacao;
            this.nomeAgente = nomeAgente;
        }

//    public Historico (String nomeIdoso, String nomeVacina, LocalDate dataAplicacao, String nomeAgente){
//        this.nomeIdoso = nomeIdoso;
//        this.nomeVacina = nomeVacina;
//        this.dataAplicacao= dataAplicacao;
//        this.nomeAgente = nomeAgente;
//    }

        public String getNomeIdoso() {
            return nomeIdoso;
        }

        public void setNomeIdoso(String nomeIdoso) {
            this.nomeIdoso = nomeIdoso;
        }

        public String getNomeVacina() {
            return nomeVacina;
        }

        public void setNomeVacina(String nomeVacina) {
            this.nomeVacina = nomeVacina;
        }

        public LocalDate getDataAplicacao() {
            return dataAplicacao;
        }

        public void setDataAplicacao(LocalDate dataAplicacao) {
            this.dataAplicacao = dataAplicacao;
        }

        public String getNomeAgente() {
            return nomeAgente;
        }

        public void setNomeAgente(String nomeAgente) {
            this.nomeAgente = nomeAgente;
        }


    }

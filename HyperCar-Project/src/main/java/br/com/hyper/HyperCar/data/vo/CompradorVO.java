package br.com.hyper.HyperCar.data.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CompradorVO {

    private String cpf;

    private String nome;

    private Integer sobrenome;

    private String enderecoFk;

    private LocalDate dataNascimento;

    private Boolean ativo;


}

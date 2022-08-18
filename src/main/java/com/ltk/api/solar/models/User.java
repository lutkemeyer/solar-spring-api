package com.ltk.api.solar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.ltk.api.solar.utils.Defaults.DATABASE_SCHEMA;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USER", schema = DATABASE_SCHEMA)
public class User extends BaseEntity {

	@Column(name = "LOGIN",
	        nullable = false,
	        length = 150)
	private String login;

	@Column(name = "PASSWORD",
	        nullable = false,
	        length = 150)
	private String password;

	//    @ManyToOne
	//    @JoinColumn(name = "IDGRUPOUSUARIO", nullable = false, foreignKey = @ForeignKey(name = "GRUPO_USUARIO_FK"))
	//    private GrupoUsuario grupoUsuario;
	
	//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//    @JoinColumn(name = "IDPESSOAFISICA", nullable = false, foreignKey = @ForeignKey(name = "PESSOA_FISICA_FK"))
	//    private PessoaFisica pessoaFisica;
	
	//    @Column(name = "PRCDESCONTOMAXIMO", nullable = false, precision = 12, scale = 5)
	//    private BigDecimal prcDescontoMaximo = BigDecimal.ZERO;
	//
	//    @Column(name = "DATALIMITEDESCONTOMAXIMO")
	//    private LocalDateTime dataLimiteDescontoMaximo;
	
	//    @ManyToOne(fetch = FetchType.LAZY)
	//    @JoinColumn(name = "IDUSUARIOCRIADOR", foreignKey = @ForeignKey(name = "USUARIO_CRIADOR_FK"))
	//    private User usuarioCriador;
	
//	    @ManyToMany(cascade = CascadeType.ALL)
	//	    @JoinTable(
	//	            name="USUARIOVALORPARAMETRO",
	//	            joinColumns = @JoinColumn(name="IDVALORPARAMETRO"),
	//	            inverseJoinColumns = @JoinColumn(name="IDUSUARIO")
	//	    )
	//	    private Set<ValorParametro> usuarioParametros;
	//
	//	    @OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	//	    private Set<AtuacaoUsuario> atuacoesUsuario = new HashSet<>();
	//
	//	    @OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	//	    private Set<Pedido> pedidos = new HashSet<>();
	//
	//	    @OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	//	    private Set<Cliente> clientes = new HashSet<>();
	
}

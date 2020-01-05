package br.com.callCenterVendas.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.callCenterVendas.model.domain.Fornecedor;
import util.ValidacaoException;

public class FornecedorDao {

	public List<Fornecedor> getFornecedores() throws SQLException, ClassNotFoundException{
		Connection conexao = ConexaoFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT CD_FORNECEDOR, NM_FORNECEDOR, DS_RAZAO_SOCIAL, DS_EMAIL, DS_CNPJ"
				+ " FROM TB_FORNECEDOR");
		ResultSet rs = ps.executeQuery();
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		while(rs.next()) {
			fornecedores.add(new Fornecedor(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(4),
					rs.getString(3),
					rs.getString(5)
					));
		}
		return fornecedores;
	}

	public void salvar(Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
		Connection conexao = ConexaoFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("INSERT INTO TB_FORNECEDOR(NM_FORNECEDOR,DS_RAZAO_SOCIAL,DS_EMAIL,DS_CNPJ) "
				+ "VALUES(?,?,?,?)");
		ps.setString(1, fornecedor.getNome());
		ps.setString(2, fornecedor.getRazaoSocial());
		ps.setString(3, fornecedor.getEmail());
		ps.setString(4, fornecedor.getCnpj());
		ps.execute();

	}

	public void excluir(Integer codFornecedor)throws ClassNotFoundException, SQLException {
		Connection conexao = ConexaoFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("DELETE FROM TB_FORNECEDOR WHERE CD_FORNECEDOR = ?");
		ps.setInt(1, codFornecedor);
		ps.execute();
	}

	public Fornecedor getFornecedorId(Integer codFornecedor) throws ClassNotFoundException, SQLException, ValidacaoException {
		Connection conexao = ConexaoFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT CD_FORNECEDOR, NM_FORNECEDOR, DS_RAZAO_SOCIAL, DS_EMAIL, DS_CNPJ"
				+ " FROM TB_FORNECEDOR WHERE CD_FORNECEDOR = ?");
		ps.setInt(1, codFornecedor);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return new Fornecedor(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(4),
					rs.getString(3),
					rs.getString(5)
					);
		}
		throw new ValidacaoException("Não há fornecedor para código: "+codFornecedor);
	}

	public void atualizar(Fornecedor fornecedor)throws ClassNotFoundException, SQLException {
		Connection conexao = ConexaoFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("UPDATE TB_FORNECEDOR SET NM_FORNECEDOR=?, DS_RAZAO_SOCIAL=?, DS_CNPJ=?, DS_EMAIL=? "
				+ "WHERE CD_FORNECEDOR=?");
		ps.setString(1, fornecedor.getNome());
		ps.setString(2, fornecedor.getRazaoSocial());
		ps.setString(3, fornecedor.getCnpj());
		ps.setString(4, fornecedor.getEmail());
		ps.setInt(5, fornecedor.getCodigo());
		ps.execute();
	}
}

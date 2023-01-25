package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class GestionBd {

	public Collection<Employe> getAllEmploye() {
		// TODO Auto-generated method stub
		Connection connection = Singleton.getInstance().getConnection();

		try {
			PreparedStatement stmt;
			stmt = connection.prepareStatement("SELECT * FROM  Employe");
			ResultSet result = stmt.executeQuery();
			Collection<Employe> listemp = new ArrayList<Employe>();

			while (result.next()) { 
				int id = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String datenaissance = result.getString("datenaissance");
				String identification = result.getString("iden");
				Employe e = new Employe(nom, prenom, datenaissance, identification);
				e.setId(id);
				listemp.add(e);
			}
			return listemp;

		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}
	
	public Boolean findEmploye(Employe employe) {
		Connection connection = Singleton.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			Statement st = connection.createStatement();
			String sql1 = "select * from employe where iden ='" + employe.getIdentification() +"'";
			ResultSet rs = st.executeQuery(sql1);
			rs.last();
			if (rs.getRow() == 0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}
	
	public int getNbrVotes(String candidat) {
		Connection connection = Singleton.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			Statement st = connection.createStatement();
			String sql1 = "select count(*) as votecount from devotant where bulltinvote like '%" + candidat +"%'";
			ResultSet rs = st.executeQuery(sql1);
			rs.next();
			int count = rs.getInt("votecount") ;
			return count;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
			return -1;
		}
	}
	
	public ArrayList<String> getCandidats(){
		ArrayList<String> list = new ArrayList<String>();
		Connection connection = Singleton.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			Statement st = connection.createStatement();
			String sql1 = "select candidat as candidat from candidats";
			ResultSet rs = st.executeQuery(sql1);
			while (rs.next()) { 
				String candidat = rs.getString("candidat");
				list.add(candidat);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
			return null;
		}
	}
	
	public Boolean findCoManager(CoManager comanager) {
		Connection connection = Singleton.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			Statement st = connection.createStatement();
			String sql1 = "select * from comanager where UPPER(email) like UPPER('" + comanager.getEmail() +"') and password ='" + comanager.getPassword() + "'";
			ResultSet rs = st.executeQuery(sql1);
			rs.last();
			if (rs.getRow() == 0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}
	
	public Boolean findDeManager(DeManager demanager) {
		Connection connection = Singleton.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			Statement st = connection.createStatement();
			String sql1 = "select * from demanager where UPPER(email) like UPPER('" + demanager.getEmail() +"') and password ='" + demanager.getPassword() + "'";
			ResultSet rs = st.executeQuery(sql1);
			rs.last();
			if (rs.getRow() == 0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}
	
	public Collection<Covotant> getAllCo() {
		// TODO Auto-generated method stub
		Connection connection = Singleton.getInstance().getConnection();

		try {
			PreparedStatement stmt;
			stmt = connection.prepareStatement("SELECT * FROM  CoVotant");
			ResultSet result = stmt.executeQuery();
			Collection<Covotant> listco = new ArrayList<Covotant>();

			while (result.next()) {
				int id = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String datenaissance = result.getString("datenaissance");
				String identification = result.getString("iden");
				String bulltinvote = result.getString("bulltinvote");
				Covotant co = new Covotant(nom, prenom, datenaissance, identification, bulltinvote);
				co.setId(id);
				listco.add(co);
			}
			return listco;

		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}

	public Collection<Devotant> getAllDe() {
		// TODO Auto-generated method stub
		Connection connection = Singleton.getInstance().getConnection();

		try {
			PreparedStatement stmt;
			stmt = connection.prepareStatement("SELECT * FROM DeVotant ");
			ResultSet result = stmt.executeQuery();
			Collection<Devotant> listde = new ArrayList<Devotant>();
			while (result.next()) {
				int id = result.getInt("id");
				String identification = result.getString("iden");
				String bulltinvote = result.getString("bulltinvote");
				Devotant de = new Devotant(identification, bulltinvote);
				de.setId(id);
				listde.add(de);
			}
			return listde;

		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}

	public Boolean setCoVotant(Covotant covotant) {
		Connection connection = Singleton.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			Statement st = connection.createStatement();
			String sql1 = "select * from CoVotant where iden ='" + covotant.getIdentification() +"'";
			ResultSet rs = st.executeQuery(sql1);
			rs.last();
			if (rs.getRow() == 0) {
				stmt = connection.prepareStatement("INSERT INTO CoVotant(nom, prenom, datenaissance, iden, bulltinvote)VALUES"
						+ "(\'"+covotant.getNom()+"\',\'"+covotant.getPrenom()+"\',\'"+covotant.getDatenaissance()
						+"\',\'"+covotant.getIdentification()+"\',\'"+covotant.getBulltinvote()+"\')");
				stmt.execute();
				return true;
			} else {
				System.out.println("ce personne est déja voter");
			}
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}

	public Boolean setDeVotant(Devotant devotant) {
		Connection connection = Singleton.getInstance().getConnection();
		try {
			Statement st = connection.createStatement();
			String sql1 = "select * from DeVotant where iden ='" + devotant.getIdentification() +"'";
			ResultSet rs = st.executeQuery(sql1);
			rs.last();
			if (rs.getRow() == 0) {
				PreparedStatement stmt;
				stmt = connection.prepareStatement("INSERT INTO DeVotant(iden, bulltinvote) VALUES(\'" + devotant.getIdentification()+ "\',\'" +devotant.getBulltinvote()+"\')");
				stmt.execute();
			}
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
			return false;
		}
		return true;
	}

}
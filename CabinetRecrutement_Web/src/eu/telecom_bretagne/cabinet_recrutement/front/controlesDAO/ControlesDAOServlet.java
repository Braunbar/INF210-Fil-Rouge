package eu.telecom_bretagne.cabinet_recrutement.front.controlesDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauQualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreEmploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteurActiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocatorException;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ControlesDAO")
public class ControlesDAOServlet extends HttpServlet {
	// -----------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlesDAOServlet() {
		super();
	}

	// -----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Flot de sortie pour écriture des résultats.
		PrintWriter out = response.getWriter();

		out.println("  =================================  ");
		checkEntreprise(out);
		out.println("  =================================  ");
		checkCandidature(out);
		out.println("  =================================  ");
		checkOffreEmploi(out);
		checkSecteurActivite(out);
		out.println("  =================================  ");
		checkNiveauQualification(out);
		out.println("  =================================  ");
	}

	protected void checkOffreEmploi(PrintWriter out) {
		// Récupération de la réféence vers le(s) DAO(s)
		OffreEmploiDAO offreEmploiDAO = null;
		try {
			offreEmploiDAO = (OffreEmploiDAO) ServicesLocator.getInstance()
					.getRemoteInterface("OffreEmploiDAO");
		} catch (ServicesLocatorException e) {
			e.printStackTrace();
		}
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des offres :");
		List<OffreEmploi> offres = offreEmploiDAO.findAll();
		for (OffreEmploi offre : offres) {
			out.println(offre.getId()+" : "+ offre.getDescriptifMission() +" : "+ offre.getProfilRecherche());
		}
		out.println();
		
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des offres par Secteur 1  et Niveau de Qualification 2 :");
		List<OffreEmploi>offres_filtre = offreEmploiDAO.findAllBySecNiv(1, 2);
		for (OffreEmploi offre : offres_filtre) {
			out.println(offre.getId()+" : "+ offre.getDescriptifMission() +" : "+ offre.getProfilRecherche());
		}
		out.println();
	
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des offres par entreprise 3 :");
		List<OffreEmploi>offres_filtre2 = offreEmploiDAO.findAllByEnt(3);
		for (OffreEmploi offre : offres_filtre2) {
			out.println(offre.getId()+" : "+ offre.getDescriptifMission() +" : "+ offre.getProfilRecherche());
		}
		out.println();
		
	}
	protected void checkSecteurActivite(PrintWriter out) {
		// Récupération de la réféence vers le(s) DAO(s)
		SecteurActiviteDAO secteurActiviteDAO = null;
		try {
			secteurActiviteDAO = (SecteurActiviteDAO) ServicesLocator.getInstance()
					.getRemoteInterface("SecteurActiviteDAO");
		} catch (ServicesLocatorException e) {
			e.printStackTrace();
		}
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des secteurs :");
		List<SecteurActivite> secs = secteurActiviteDAO.findAll();
		for (SecteurActivite sec : secs) {
			out.println(sec.getId()+" : "+ sec.getIntitule());
		}
		out.println();
	
	}
	
	protected void checkNiveauQualification(PrintWriter out) {
		// Récupération de la réféence vers le(s) DAO(s)
		NiveauQualificationDAO niveauQualificationDAO = null;
		try {
			niveauQualificationDAO = (NiveauQualificationDAO) ServicesLocator.getInstance()
					.getRemoteInterface("NiveauQualificationDAO");
		} catch (ServicesLocatorException e) {
			e.printStackTrace();
		}
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des niveaux de qualification :");
		List<NiveauQualification> nivQuas = niveauQualificationDAO.findAll();
		for (NiveauQualification nivQua : nivQuas) {
			out.println(nivQua.getId()+" : "+ nivQua.getIntitule());
		}
		out.println();
	
	}
	

	protected void checkCandidature(PrintWriter out) {
		// Récupération de la réféence vers le(s) DAO(s)
		CandidatureDAO candidatureDAO = null;
		try {
			candidatureDAO = (CandidatureDAO) ServicesLocator.getInstance()
					.getRemoteInterface("CandidatureDAO");
		} catch (ServicesLocatorException e) {
			e.printStackTrace();
		}
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des candidatures :");
		List<Candidature> candidatures = candidatureDAO.findAll();
		for (Candidature candidature : candidatures) {
			out.println(candidature.getId() +" : "+ candidature.getNom());
		}
		out.println();


		out.println("Obtention de la candidature n°1 :");
		Candidature e  = candidatureDAO.findById(2);
		out.println(e.getId());
		out.println(e.getNom());
		out.println(e.getAdresseMail());
		out.println();

		// Contrôle(s) de fonctionnalités.
		out.println("Liste des candidatures par Secteur 1  et Niveau de Qualification 2 :");
		List<Candidature> candidatures_filtre = candidatureDAO.findAllBy(1, 2);
		for (Candidature candidature : candidatures_filtre) {
			out.println(candidature.getId() +" : "+ candidature.getNom());
		}
		out.println();
	}
	protected void checkEntreprise(PrintWriter out) {
		// Récupération de la réféence vers le(s) DAO(s)
		EntrepriseDAO entrepriseDAO = null;
		try {
			entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance()
					.getRemoteInterface("EntrepriseDAO");
		} catch (ServicesLocatorException e) {
			e.printStackTrace();
		}
		
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des entreprises :");
		List<Entreprise> entreprises = entrepriseDAO.findAll();

		for (Entreprise entreprise : entreprises) {
			out.println(entreprise.getNom());
		}
		out.println();

		out.println("Obtention de l'entreprise n° 1 :");
		Entreprise e = entrepriseDAO.findById(1);
		out.println(e.getId());
		out.println(e.getNom());
		out.println(e.getDescriptif());
		out.println(e.getAdressePostale());
		out.println();

		out.println("Obtention de l'entreprise n° 2 :");
		e = entrepriseDAO.findById(2);
		out.println(e.getId());
		out.println(e.getNom());
		out.println(e.getDescriptif());
		out.println(e.getAdressePostale());
		out.println();
		
	}
	// -----------------------------------------------------------------------------
}

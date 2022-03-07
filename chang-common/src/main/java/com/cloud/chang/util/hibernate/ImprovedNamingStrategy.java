package com.cloud.chang.util.hibernate;

import java.util.Locale;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.internal.util.StringHelper;

/**
 * fix naming strategy for hibernate 5.x aaBbCc --> aa_bb_cc
 * 
 * @author bingyunxl
 *
 */
public class ImprovedNamingStrategy implements PhysicalNamingStrategy {

	/**
	 * Singleton access
	 */
	public static final ImprovedNamingStrategy INSTANCE = new ImprovedNamingStrategy();

	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment context) {
		return name;
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment context) {
		return name;
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		String newName = addUnderscores(name.getText());
		return Identifier.toIdentifier(newName);
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment context) {
		return name;
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		String newName = addUnderscores(StringHelper.unqualify(name.getText()));
		return Identifier.toIdentifier(newName);
	}

	protected String addUnderscores(String name) {
		StringBuilder buf = new StringBuilder(name.replace('.', '_'));
		for (int i = 1; i < buf.length() - 1; i++) {
			if (Character.isLowerCase(buf.charAt(i - 1)) && Character.isUpperCase(buf.charAt(i))
					&& Character.isLowerCase(buf.charAt(i + 1))) {
				buf.insert(i++, '_');
			}
		}
		return buf.toString().toLowerCase(Locale.ROOT);
	}

}

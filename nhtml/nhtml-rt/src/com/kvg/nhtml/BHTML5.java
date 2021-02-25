package com.kvg.nhtml;

import javax.baja.agent.AgentList;
import javax.baja.collection.BITable;
import javax.baja.collection.ColumnList;
import javax.baja.collection.TableCursor;
import javax.baja.file.BFileSystem;
import javax.baja.file.BIFile;
import javax.baja.file.FilePath;
import javax.baja.gx.BBrush;
import javax.baja.gx.BColor;
import javax.baja.naming.BOrd;
import javax.baja.naming.OrdQuery;
import javax.baja.naming.UnresolvedException;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.io.*;
import java.util.Date;


@NiagaraType

@NiagaraProperty(
        name = "gettingStarted",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "To view the getting started guide search \"nhtml\" on the internal sbs wiki",
        facets = {
                @Facet(name = "BFacets.FIELD_WIDTH", value = "90")

        }
)
@NiagaraProperty(
        name = "htmlLastGenerated",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "never"
)

@NiagaraProperty(
        name = "htmlFolder",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"file:^graphics/html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IDirectory\"")
        }
)
@NiagaraProperty(
        name = "navFile",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/nav.nav\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)

@NiagaraProperty(
        name = "equipHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/equip.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "indexHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/index.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "scriptJS",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/js/script.js\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "styleCSS",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/css/style.css\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "customCssFile",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/css/custom.css\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)


@NiagaraProperty(
        name = "bajascriptJs",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/js/bajascript.js\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)

@NiagaraProperty(
        name = "floorplanHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/floorplans.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "customHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/customNav.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "externalHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/external.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)


@NiagaraProperty(
        name = "navCSS",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/css/nav.css\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "logoCSS",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/css/logo.css\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)

@NiagaraProperty(
        name = "siteTitle",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Niagara"

)


@NiagaraProperty(
        name = "logoPath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"file:^graphics/images/logo.png\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }

)
@NiagaraProperty(
        name = "minLogoWidth",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "150"
)
@NiagaraProperty(
        name = "maxLogoWidth",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "250"
)
@NiagaraProperty(
        name = "logoTopPadding",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "-10"
)
@NiagaraProperty(
        name = "navColor",
        type = "gx:Brush",
        flags = Flags.SUMMARY,
        defaultValue = "BBrush.makeSolid(BColor.orange)"

)

@NiagaraProperty(
        name = "customCss",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "",
        facets = {
                @Facet(name = "BFacets.MULTI_LINE", value = "true")

        }
)
@NiagaraProperty(
        name = "hasOat",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)
@NiagaraProperty(
        name = "oat",
        type = "BString",
        flags = Flags.SUMMARY,
        defaultValue = "0"

)
@NiagaraProperty(
        name = "hasOah",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "oah",
        type = "BString",
        flags = Flags.SUMMARY,
        defaultValue = "0"
)

@NiagaraProperty(
        name = "homePagePath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Sites/Building$20Name\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)


@NiagaraProperty(
        name = "hasEntSec",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "hasEquipment",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "equipListName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Equipment"

)

@NiagaraProperty(
        name = "hasFloorplans",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "floorplanListName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Floorplans"

)
@NiagaraProperty(
        name = "hasCustomNavItem",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "customListName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Custom"

)
@NiagaraProperty(
        name = "hasExternalLink",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "externalLinkName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "External Link"

)
@NiagaraProperty(
        name = "externalLinkPath",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = ""

)
@NiagaraProperty(
        name = "showHistories",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)
@NiagaraProperty(
        name = "showSchedules",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)
@NiagaraProperty(
        name = "schedulePagePath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Schedules\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)
@NiagaraProperty(
        name = "showReports",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)
@NiagaraProperty(
        name = "showDocs",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)

@NiagaraProperty(
        name = "hasNotificationConsole",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "notificationConsoleName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Notifications"

)
@NiagaraProperty(
        name = "notificationCount",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "0"
)
@NiagaraProperty(
        name = "notificationConsolePath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Services/AlarmService/AllNotifications\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)
@NiagaraProperty(
        name = "hasAlarmConsole",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "alarmConsoleName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Alarms"

)

@NiagaraProperty(
        name = "alarmCount",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "0"
)
@NiagaraProperty(
        name = "alarmConsolePath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Services/AlarmService/AllAlarms\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)



@NiagaraAction(
        name = "generateHTML"
)

public class BHTML5 extends BComponent {


    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.kvg.nhtml.BHTML5(2532556021)1.0$ @*/
/* Generated Fri Dec 11 11:57:00 COT 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "gettingStarted"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code gettingStarted} property.
   * @see #getGettingStarted
   * @see #setGettingStarted
   */
  public static final Property gettingStarted = newProperty(Flags.SUMMARY | Flags.READONLY, "To view the getting started guide search \"nhtml\" on the internal sbs wiki", BFacets.make(BFacets.FIELD_WIDTH, 90));
  
  /**
   * Get the {@code gettingStarted} property.
   * @see #gettingStarted
   */
  public String getGettingStarted() { return getString(gettingStarted); }
  
  /**
   * Set the {@code gettingStarted} property.
   * @see #gettingStarted
   */
  public void setGettingStarted(String v) { setString(gettingStarted, v, null); }

////////////////////////////////////////////////////////////////
// Property "htmlLastGenerated"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code htmlLastGenerated} property.
   * @see #getHtmlLastGenerated
   * @see #setHtmlLastGenerated
   */
  public static final Property htmlLastGenerated = newProperty(Flags.SUMMARY | Flags.READONLY, "never", null);
  
  /**
   * Get the {@code htmlLastGenerated} property.
   * @see #htmlLastGenerated
   */
  public String getHtmlLastGenerated() { return getString(htmlLastGenerated); }
  
  /**
   * Set the {@code htmlLastGenerated} property.
   * @see #htmlLastGenerated
   */
  public void setHtmlLastGenerated(String v) { setString(htmlLastGenerated, v, null); }

////////////////////////////////////////////////////////////////
// Property "htmlFolder"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code htmlFolder} property.
   * @see #getHtmlFolder
   * @see #setHtmlFolder
   */
  public static final Property htmlFolder = newProperty(Flags.SUMMARY, BOrd.make("file:^graphics/html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IDirectory"));
  
  /**
   * Get the {@code htmlFolder} property.
   * @see #htmlFolder
   */
  public BOrd getHtmlFolder() { return (BOrd)get(htmlFolder); }
  
  /**
   * Set the {@code htmlFolder} property.
   * @see #htmlFolder
   */
  public void setHtmlFolder(BOrd v) { set(htmlFolder, v, null); }

////////////////////////////////////////////////////////////////
// Property "navFile"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code navFile} property.
   * @see #getNavFile
   * @see #setNavFile
   */
  public static final Property navFile = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/nav.nav"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code navFile} property.
   * @see #navFile
   */
  public BOrd getNavFile() { return (BOrd)get(navFile); }
  
  /**
   * Set the {@code navFile} property.
   * @see #navFile
   */
  public void setNavFile(BOrd v) { set(navFile, v, null); }

////////////////////////////////////////////////////////////////
// Property "equipHTML"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code equipHTML} property.
   * @see #getEquipHTML
   * @see #setEquipHTML
   */
  public static final Property equipHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/equip.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code equipHTML} property.
   * @see #equipHTML
   */
  public BOrd getEquipHTML() { return (BOrd)get(equipHTML); }
  
  /**
   * Set the {@code equipHTML} property.
   * @see #equipHTML
   */
  public void setEquipHTML(BOrd v) { set(equipHTML, v, null); }

////////////////////////////////////////////////////////////////
// Property "indexHTML"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code indexHTML} property.
   * @see #getIndexHTML
   * @see #setIndexHTML
   */
  public static final Property indexHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/index.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code indexHTML} property.
   * @see #indexHTML
   */
  public BOrd getIndexHTML() { return (BOrd)get(indexHTML); }
  
  /**
   * Set the {@code indexHTML} property.
   * @see #indexHTML
   */
  public void setIndexHTML(BOrd v) { set(indexHTML, v, null); }

////////////////////////////////////////////////////////////////
// Property "scriptJS"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code scriptJS} property.
   * @see #getScriptJS
   * @see #setScriptJS
   */
  public static final Property scriptJS = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/js/script.js"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code scriptJS} property.
   * @see #scriptJS
   */
  public BOrd getScriptJS() { return (BOrd)get(scriptJS); }
  
  /**
   * Set the {@code scriptJS} property.
   * @see #scriptJS
   */
  public void setScriptJS(BOrd v) { set(scriptJS, v, null); }

////////////////////////////////////////////////////////////////
// Property "styleCSS"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code styleCSS} property.
   * @see #getStyleCSS
   * @see #setStyleCSS
   */
  public static final Property styleCSS = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/css/style.css"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code styleCSS} property.
   * @see #styleCSS
   */
  public BOrd getStyleCSS() { return (BOrd)get(styleCSS); }
  
  /**
   * Set the {@code styleCSS} property.
   * @see #styleCSS
   */
  public void setStyleCSS(BOrd v) { set(styleCSS, v, null); }

////////////////////////////////////////////////////////////////
// Property "customCssFile"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code customCssFile} property.
   * @see #getCustomCssFile
   * @see #setCustomCssFile
   */
  public static final Property customCssFile = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/css/custom.css"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code customCssFile} property.
   * @see #customCssFile
   */
  public BOrd getCustomCssFile() { return (BOrd)get(customCssFile); }
  
  /**
   * Set the {@code customCssFile} property.
   * @see #customCssFile
   */
  public void setCustomCssFile(BOrd v) { set(customCssFile, v, null); }

////////////////////////////////////////////////////////////////
// Property "bajascriptJs"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code bajascriptJs} property.
   * @see #getBajascriptJs
   * @see #setBajascriptJs
   */
  public static final Property bajascriptJs = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/js/bajascript.js"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code bajascriptJs} property.
   * @see #bajascriptJs
   */
  public BOrd getBajascriptJs() { return (BOrd)get(bajascriptJs); }
  
  /**
   * Set the {@code bajascriptJs} property.
   * @see #bajascriptJs
   */
  public void setBajascriptJs(BOrd v) { set(bajascriptJs, v, null); }

////////////////////////////////////////////////////////////////
// Property "floorplanHTML"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code floorplanHTML} property.
   * @see #getFloorplanHTML
   * @see #setFloorplanHTML
   */
  public static final Property floorplanHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/floorplans.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code floorplanHTML} property.
   * @see #floorplanHTML
   */
  public BOrd getFloorplanHTML() { return (BOrd)get(floorplanHTML); }
  
  /**
   * Set the {@code floorplanHTML} property.
   * @see #floorplanHTML
   */
  public void setFloorplanHTML(BOrd v) { set(floorplanHTML, v, null); }

////////////////////////////////////////////////////////////////
// Property "customHTML"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code customHTML} property.
   * @see #getCustomHTML
   * @see #setCustomHTML
   */
  public static final Property customHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/customNav.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code customHTML} property.
   * @see #customHTML
   */
  public BOrd getCustomHTML() { return (BOrd)get(customHTML); }
  
  /**
   * Set the {@code customHTML} property.
   * @see #customHTML
   */
  public void setCustomHTML(BOrd v) { set(customHTML, v, null); }

////////////////////////////////////////////////////////////////
// Property "externalHTML"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code externalHTML} property.
   * @see #getExternalHTML
   * @see #setExternalHTML
   */
  public static final Property externalHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/external.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code externalHTML} property.
   * @see #externalHTML
   */
  public BOrd getExternalHTML() { return (BOrd)get(externalHTML); }
  
  /**
   * Set the {@code externalHTML} property.
   * @see #externalHTML
   */
  public void setExternalHTML(BOrd v) { set(externalHTML, v, null); }

////////////////////////////////////////////////////////////////
// Property "navCSS"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code navCSS} property.
   * @see #getNavCSS
   * @see #setNavCSS
   */
  public static final Property navCSS = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/css/nav.css"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code navCSS} property.
   * @see #navCSS
   */
  public BOrd getNavCSS() { return (BOrd)get(navCSS); }
  
  /**
   * Set the {@code navCSS} property.
   * @see #navCSS
   */
  public void setNavCSS(BOrd v) { set(navCSS, v, null); }

////////////////////////////////////////////////////////////////
// Property "logoCSS"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code logoCSS} property.
   * @see #getLogoCSS
   * @see #setLogoCSS
   */
  public static final Property logoCSS = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/css/logo.css"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code logoCSS} property.
   * @see #logoCSS
   */
  public BOrd getLogoCSS() { return (BOrd)get(logoCSS); }
  
  /**
   * Set the {@code logoCSS} property.
   * @see #logoCSS
   */
  public void setLogoCSS(BOrd v) { set(logoCSS, v, null); }

////////////////////////////////////////////////////////////////
// Property "siteTitle"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code siteTitle} property.
   * @see #getSiteTitle
   * @see #setSiteTitle
   */
  public static final Property siteTitle = newProperty(Flags.SUMMARY, "Niagara", null);
  
  /**
   * Get the {@code siteTitle} property.
   * @see #siteTitle
   */
  public String getSiteTitle() { return getString(siteTitle); }
  
  /**
   * Set the {@code siteTitle} property.
   * @see #siteTitle
   */
  public void setSiteTitle(String v) { setString(siteTitle, v, null); }

////////////////////////////////////////////////////////////////
// Property "logoPath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code logoPath} property.
   * @see #getLogoPath
   * @see #setLogoPath
   */
  public static final Property logoPath = newProperty(Flags.SUMMARY, BOrd.make("file:^graphics/images/logo.png"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code logoPath} property.
   * @see #logoPath
   */
  public BOrd getLogoPath() { return (BOrd)get(logoPath); }
  
  /**
   * Set the {@code logoPath} property.
   * @see #logoPath
   */
  public void setLogoPath(BOrd v) { set(logoPath, v, null); }

////////////////////////////////////////////////////////////////
// Property "minLogoWidth"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code minLogoWidth} property.
   * @see #getMinLogoWidth
   * @see #setMinLogoWidth
   */
  public static final Property minLogoWidth = newProperty(Flags.SUMMARY, 150, null);
  
  /**
   * Get the {@code minLogoWidth} property.
   * @see #minLogoWidth
   */
  public double getMinLogoWidth() { return getDouble(minLogoWidth); }
  
  /**
   * Set the {@code minLogoWidth} property.
   * @see #minLogoWidth
   */
  public void setMinLogoWidth(double v) { setDouble(minLogoWidth, v, null); }

////////////////////////////////////////////////////////////////
// Property "maxLogoWidth"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code maxLogoWidth} property.
   * @see #getMaxLogoWidth
   * @see #setMaxLogoWidth
   */
  public static final Property maxLogoWidth = newProperty(Flags.SUMMARY, 250, null);
  
  /**
   * Get the {@code maxLogoWidth} property.
   * @see #maxLogoWidth
   */
  public double getMaxLogoWidth() { return getDouble(maxLogoWidth); }
  
  /**
   * Set the {@code maxLogoWidth} property.
   * @see #maxLogoWidth
   */
  public void setMaxLogoWidth(double v) { setDouble(maxLogoWidth, v, null); }

////////////////////////////////////////////////////////////////
// Property "logoTopPadding"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code logoTopPadding} property.
   * @see #getLogoTopPadding
   * @see #setLogoTopPadding
   */
  public static final Property logoTopPadding = newProperty(Flags.SUMMARY, -10, null);
  
  /**
   * Get the {@code logoTopPadding} property.
   * @see #logoTopPadding
   */
  public double getLogoTopPadding() { return getDouble(logoTopPadding); }
  
  /**
   * Set the {@code logoTopPadding} property.
   * @see #logoTopPadding
   */
  public void setLogoTopPadding(double v) { setDouble(logoTopPadding, v, null); }

////////////////////////////////////////////////////////////////
// Property "navColor"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code navColor} property.
   * @see #getNavColor
   * @see #setNavColor
   */
  public static final Property navColor = newProperty(Flags.SUMMARY, BBrush.makeSolid(BColor.orange), null);
  
  /**
   * Get the {@code navColor} property.
   * @see #navColor
   */
  public BBrush getNavColor() { return (BBrush)get(navColor); }
  
  /**
   * Set the {@code navColor} property.
   * @see #navColor
   */
  public void setNavColor(BBrush v) { set(navColor, v, null); }

////////////////////////////////////////////////////////////////
// Property "customCss"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code customCss} property.
   * @see #getCustomCss
   * @see #setCustomCss
   */
  public static final Property customCss = newProperty(Flags.SUMMARY, "", BFacets.make(BFacets.MULTI_LINE, true));
  
  /**
   * Get the {@code customCss} property.
   * @see #customCss
   */
  public String getCustomCss() { return getString(customCss); }
  
  /**
   * Set the {@code customCss} property.
   * @see #customCss
   */
  public void setCustomCss(String v) { setString(customCss, v, null); }

////////////////////////////////////////////////////////////////
// Property "hasOat"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasOat} property.
   * @see #getHasOat
   * @see #setHasOat
   */
  public static final Property hasOat = newProperty(Flags.SUMMARY, true, null);
  
  /**
   * Get the {@code hasOat} property.
   * @see #hasOat
   */
  public boolean getHasOat() { return getBoolean(hasOat); }
  
  /**
   * Set the {@code hasOat} property.
   * @see #hasOat
   */
  public void setHasOat(boolean v) { setBoolean(hasOat, v, null); }

////////////////////////////////////////////////////////////////
// Property "oat"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code oat} property.
   * @see #getOat
   * @see #setOat
   */
  public static final Property oat = newProperty(Flags.SUMMARY, "0", null);
  
  /**
   * Get the {@code oat} property.
   * @see #oat
   */
  public String getOat() { return getString(oat); }
  
  /**
   * Set the {@code oat} property.
   * @see #oat
   */
  public void setOat(String v) { setString(oat, v, null); }

////////////////////////////////////////////////////////////////
// Property "hasOah"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasOah} property.
   * @see #getHasOah
   * @see #setHasOah
   */
  public static final Property hasOah = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code hasOah} property.
   * @see #hasOah
   */
  public boolean getHasOah() { return getBoolean(hasOah); }
  
  /**
   * Set the {@code hasOah} property.
   * @see #hasOah
   */
  public void setHasOah(boolean v) { setBoolean(hasOah, v, null); }

////////////////////////////////////////////////////////////////
// Property "oah"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code oah} property.
   * @see #getOah
   * @see #setOah
   */
  public static final Property oah = newProperty(Flags.SUMMARY, "0", null);
  
  /**
   * Get the {@code oah} property.
   * @see #oah
   */
  public String getOah() { return getString(oah); }
  
  /**
   * Set the {@code oah} property.
   * @see #oah
   */
  public void setOah(String v) { setString(oah, v, null); }

////////////////////////////////////////////////////////////////
// Property "homePagePath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code homePagePath} property.
   * @see #getHomePagePath
   * @see #setHomePagePath
   */
  public static final Property homePagePath = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Sites/Building$20Name"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code homePagePath} property.
   * @see #homePagePath
   */
  public BOrd getHomePagePath() { return (BOrd)get(homePagePath); }
  
  /**
   * Set the {@code homePagePath} property.
   * @see #homePagePath
   */
  public void setHomePagePath(BOrd v) { set(homePagePath, v, null); }

////////////////////////////////////////////////////////////////
// Property "hasEntSec"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasEntSec} property.
   * @see #getHasEntSec
   * @see #setHasEntSec
   */
  public static final Property hasEntSec = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code hasEntSec} property.
   * @see #hasEntSec
   */
  public boolean getHasEntSec() { return getBoolean(hasEntSec); }
  
  /**
   * Set the {@code hasEntSec} property.
   * @see #hasEntSec
   */
  public void setHasEntSec(boolean v) { setBoolean(hasEntSec, v, null); }

////////////////////////////////////////////////////////////////
// Property "hasEquipment"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasEquipment} property.
   * @see #getHasEquipment
   * @see #setHasEquipment
   */
  public static final Property hasEquipment = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code hasEquipment} property.
   * @see #hasEquipment
   */
  public boolean getHasEquipment() { return getBoolean(hasEquipment); }
  
  /**
   * Set the {@code hasEquipment} property.
   * @see #hasEquipment
   */
  public void setHasEquipment(boolean v) { setBoolean(hasEquipment, v, null); }

////////////////////////////////////////////////////////////////
// Property "equipListName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code equipListName} property.
   * @see #getEquipListName
   * @see #setEquipListName
   */
  public static final Property equipListName = newProperty(Flags.SUMMARY, "Equipment", null);
  
  /**
   * Get the {@code equipListName} property.
   * @see #equipListName
   */
  public String getEquipListName() { return getString(equipListName); }
  
  /**
   * Set the {@code equipListName} property.
   * @see #equipListName
   */
  public void setEquipListName(String v) { setString(equipListName, v, null); }

////////////////////////////////////////////////////////////////
// Property "hasFloorplans"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasFloorplans} property.
   * @see #getHasFloorplans
   * @see #setHasFloorplans
   */
  public static final Property hasFloorplans = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code hasFloorplans} property.
   * @see #hasFloorplans
   */
  public boolean getHasFloorplans() { return getBoolean(hasFloorplans); }
  
  /**
   * Set the {@code hasFloorplans} property.
   * @see #hasFloorplans
   */
  public void setHasFloorplans(boolean v) { setBoolean(hasFloorplans, v, null); }

////////////////////////////////////////////////////////////////
// Property "floorplanListName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code floorplanListName} property.
   * @see #getFloorplanListName
   * @see #setFloorplanListName
   */
  public static final Property floorplanListName = newProperty(Flags.SUMMARY, "Floorplans", null);
  
  /**
   * Get the {@code floorplanListName} property.
   * @see #floorplanListName
   */
  public String getFloorplanListName() { return getString(floorplanListName); }
  
  /**
   * Set the {@code floorplanListName} property.
   * @see #floorplanListName
   */
  public void setFloorplanListName(String v) { setString(floorplanListName, v, null); }

////////////////////////////////////////////////////////////////
// Property "hasCustomNavItem"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasCustomNavItem} property.
   * @see #getHasCustomNavItem
   * @see #setHasCustomNavItem
   */
  public static final Property hasCustomNavItem = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code hasCustomNavItem} property.
   * @see #hasCustomNavItem
   */
  public boolean getHasCustomNavItem() { return getBoolean(hasCustomNavItem); }
  
  /**
   * Set the {@code hasCustomNavItem} property.
   * @see #hasCustomNavItem
   */
  public void setHasCustomNavItem(boolean v) { setBoolean(hasCustomNavItem, v, null); }

////////////////////////////////////////////////////////////////
// Property "customListName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code customListName} property.
   * @see #getCustomListName
   * @see #setCustomListName
   */
  public static final Property customListName = newProperty(Flags.SUMMARY, "Custom", null);
  
  /**
   * Get the {@code customListName} property.
   * @see #customListName
   */
  public String getCustomListName() { return getString(customListName); }
  
  /**
   * Set the {@code customListName} property.
   * @see #customListName
   */
  public void setCustomListName(String v) { setString(customListName, v, null); }

////////////////////////////////////////////////////////////////
// Property "hasExternalLink"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasExternalLink} property.
   * @see #getHasExternalLink
   * @see #setHasExternalLink
   */
  public static final Property hasExternalLink = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code hasExternalLink} property.
   * @see #hasExternalLink
   */
  public boolean getHasExternalLink() { return getBoolean(hasExternalLink); }
  
  /**
   * Set the {@code hasExternalLink} property.
   * @see #hasExternalLink
   */
  public void setHasExternalLink(boolean v) { setBoolean(hasExternalLink, v, null); }

////////////////////////////////////////////////////////////////
// Property "externalLinkName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code externalLinkName} property.
   * @see #getExternalLinkName
   * @see #setExternalLinkName
   */
  public static final Property externalLinkName = newProperty(Flags.SUMMARY, "External Link", null);
  
  /**
   * Get the {@code externalLinkName} property.
   * @see #externalLinkName
   */
  public String getExternalLinkName() { return getString(externalLinkName); }
  
  /**
   * Set the {@code externalLinkName} property.
   * @see #externalLinkName
   */
  public void setExternalLinkName(String v) { setString(externalLinkName, v, null); }

////////////////////////////////////////////////////////////////
// Property "externalLinkPath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code externalLinkPath} property.
   * @see #getExternalLinkPath
   * @see #setExternalLinkPath
   */
  public static final Property externalLinkPath = newProperty(Flags.SUMMARY, "", null);
  
  /**
   * Get the {@code externalLinkPath} property.
   * @see #externalLinkPath
   */
  public String getExternalLinkPath() { return getString(externalLinkPath); }
  
  /**
   * Set the {@code externalLinkPath} property.
   * @see #externalLinkPath
   */
  public void setExternalLinkPath(String v) { setString(externalLinkPath, v, null); }

////////////////////////////////////////////////////////////////
// Property "showHistories"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code showHistories} property.
   * @see #getShowHistories
   * @see #setShowHistories
   */
  public static final Property showHistories = newProperty(Flags.SUMMARY, true, null);
  
  /**
   * Get the {@code showHistories} property.
   * @see #showHistories
   */
  public boolean getShowHistories() { return getBoolean(showHistories); }
  
  /**
   * Set the {@code showHistories} property.
   * @see #showHistories
   */
  public void setShowHistories(boolean v) { setBoolean(showHistories, v, null); }

////////////////////////////////////////////////////////////////
// Property "showSchedules"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code showSchedules} property.
   * @see #getShowSchedules
   * @see #setShowSchedules
   */
  public static final Property showSchedules = newProperty(Flags.SUMMARY, true, null);
  
  /**
   * Get the {@code showSchedules} property.
   * @see #showSchedules
   */
  public boolean getShowSchedules() { return getBoolean(showSchedules); }
  
  /**
   * Set the {@code showSchedules} property.
   * @see #showSchedules
   */
  public void setShowSchedules(boolean v) { setBoolean(showSchedules, v, null); }

////////////////////////////////////////////////////////////////
// Property "schedulePagePath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code schedulePagePath} property.
   * @see #getSchedulePagePath
   * @see #setSchedulePagePath
   */
  public static final Property schedulePagePath = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Schedules"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code schedulePagePath} property.
   * @see #schedulePagePath
   */
  public BOrd getSchedulePagePath() { return (BOrd)get(schedulePagePath); }
  
  /**
   * Set the {@code schedulePagePath} property.
   * @see #schedulePagePath
   */
  public void setSchedulePagePath(BOrd v) { set(schedulePagePath, v, null); }

////////////////////////////////////////////////////////////////
// Property "showReports"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code showReports} property.
   * @see #getShowReports
   * @see #setShowReports
   */
  public static final Property showReports = newProperty(Flags.SUMMARY, true, null);
  
  /**
   * Get the {@code showReports} property.
   * @see #showReports
   */
  public boolean getShowReports() { return getBoolean(showReports); }
  
  /**
   * Set the {@code showReports} property.
   * @see #showReports
   */
  public void setShowReports(boolean v) { setBoolean(showReports, v, null); }

////////////////////////////////////////////////////////////////
// Property "showDocs"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code showDocs} property.
   * @see #getShowDocs
   * @see #setShowDocs
   */
  public static final Property showDocs = newProperty(Flags.SUMMARY, true, null);
  
  /**
   * Get the {@code showDocs} property.
   * @see #showDocs
   */
  public boolean getShowDocs() { return getBoolean(showDocs); }
  
  /**
   * Set the {@code showDocs} property.
   * @see #showDocs
   */
  public void setShowDocs(boolean v) { setBoolean(showDocs, v, null); }

////////////////////////////////////////////////////////////////
// Property "hasNotificationConsole"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasNotificationConsole} property.
   * @see #getHasNotificationConsole
   * @see #setHasNotificationConsole
   */
  public static final Property hasNotificationConsole = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code hasNotificationConsole} property.
   * @see #hasNotificationConsole
   */
  public boolean getHasNotificationConsole() { return getBoolean(hasNotificationConsole); }
  
  /**
   * Set the {@code hasNotificationConsole} property.
   * @see #hasNotificationConsole
   */
  public void setHasNotificationConsole(boolean v) { setBoolean(hasNotificationConsole, v, null); }

////////////////////////////////////////////////////////////////
// Property "notificationConsoleName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code notificationConsoleName} property.
   * @see #getNotificationConsoleName
   * @see #setNotificationConsoleName
   */
  public static final Property notificationConsoleName = newProperty(Flags.SUMMARY, "Notifications", null);
  
  /**
   * Get the {@code notificationConsoleName} property.
   * @see #notificationConsoleName
   */
  public String getNotificationConsoleName() { return getString(notificationConsoleName); }
  
  /**
   * Set the {@code notificationConsoleName} property.
   * @see #notificationConsoleName
   */
  public void setNotificationConsoleName(String v) { setString(notificationConsoleName, v, null); }

////////////////////////////////////////////////////////////////
// Property "notificationCount"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code notificationCount} property.
   * @see #getNotificationCount
   * @see #setNotificationCount
   */
  public static final Property notificationCount = newProperty(Flags.SUMMARY, 0, null);
  
  /**
   * Get the {@code notificationCount} property.
   * @see #notificationCount
   */
  public double getNotificationCount() { return getDouble(notificationCount); }
  
  /**
   * Set the {@code notificationCount} property.
   * @see #notificationCount
   */
  public void setNotificationCount(double v) { setDouble(notificationCount, v, null); }

////////////////////////////////////////////////////////////////
// Property "notificationConsolePath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code notificationConsolePath} property.
   * @see #getNotificationConsolePath
   * @see #setNotificationConsolePath
   */
  public static final Property notificationConsolePath = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Services/AlarmService/AllNotifications"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code notificationConsolePath} property.
   * @see #notificationConsolePath
   */
  public BOrd getNotificationConsolePath() { return (BOrd)get(notificationConsolePath); }
  
  /**
   * Set the {@code notificationConsolePath} property.
   * @see #notificationConsolePath
   */
  public void setNotificationConsolePath(BOrd v) { set(notificationConsolePath, v, null); }

////////////////////////////////////////////////////////////////
// Property "hasAlarmConsole"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasAlarmConsole} property.
   * @see #getHasAlarmConsole
   * @see #setHasAlarmConsole
   */
  public static final Property hasAlarmConsole = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code hasAlarmConsole} property.
   * @see #hasAlarmConsole
   */
  public boolean getHasAlarmConsole() { return getBoolean(hasAlarmConsole); }
  
  /**
   * Set the {@code hasAlarmConsole} property.
   * @see #hasAlarmConsole
   */
  public void setHasAlarmConsole(boolean v) { setBoolean(hasAlarmConsole, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmConsoleName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmConsoleName} property.
   * @see #getAlarmConsoleName
   * @see #setAlarmConsoleName
   */
  public static final Property alarmConsoleName = newProperty(Flags.SUMMARY, "Alarms", null);
  
  /**
   * Get the {@code alarmConsoleName} property.
   * @see #alarmConsoleName
   */
  public String getAlarmConsoleName() { return getString(alarmConsoleName); }
  
  /**
   * Set the {@code alarmConsoleName} property.
   * @see #alarmConsoleName
   */
  public void setAlarmConsoleName(String v) { setString(alarmConsoleName, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmCount"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmCount} property.
   * @see #getAlarmCount
   * @see #setAlarmCount
   */
  public static final Property alarmCount = newProperty(Flags.SUMMARY, 0, null);
  
  /**
   * Get the {@code alarmCount} property.
   * @see #alarmCount
   */
  public double getAlarmCount() { return getDouble(alarmCount); }
  
  /**
   * Set the {@code alarmCount} property.
   * @see #alarmCount
   */
  public void setAlarmCount(double v) { setDouble(alarmCount, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmConsolePath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmConsolePath} property.
   * @see #getAlarmConsolePath
   * @see #setAlarmConsolePath
   */
  public static final Property alarmConsolePath = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Services/AlarmService/AllAlarms"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code alarmConsolePath} property.
   * @see #alarmConsolePath
   */
  public BOrd getAlarmConsolePath() { return (BOrd)get(alarmConsolePath); }
  
  /**
   * Set the {@code alarmConsolePath} property.
   * @see #alarmConsolePath
   */
  public void setAlarmConsolePath(BOrd v) { set(alarmConsolePath, v, null); }

////////////////////////////////////////////////////////////////
// Action "generateHTML"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code generateHTML} action.
   * @see #generateHTML()
   */
  public static final Action generateHTML = newAction(0, null);
  
  /**
   * Invoke the {@code generateHTML} action.
   * @see #generateHTML
   */
  public void generateHTML() { invoke(generateHTML, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHTML5.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


    public void doGenerateHTML() {


        //setup folder paths & file locations
        String htmlFolder = getHtmlFolder().toString();
        setEquipHTML(BOrd.make(htmlFolder + "/equip.html"));
        setCustomHTML(BOrd.make(htmlFolder + "/customNav.html"));
        setExternalHTML(BOrd.make(htmlFolder + "/external.html"));
        setFloorplanHTML(BOrd.make(htmlFolder + "/floorplans.html"));
        setIndexHTML(BOrd.make(htmlFolder + "/index.html"));
        setNavFile(BOrd.make(htmlFolder + "/nav/nav.nav"));
        setBajascriptJs(BOrd.make(htmlFolder + "/js/bajascript.js"));
        setScriptJS(BOrd.make(htmlFolder + "/js/script.js"));
        setLogoCSS(BOrd.make(htmlFolder + "/css/logo.css"));
        setNavCSS(BOrd.make(htmlFolder + "/css/nav.css"));
        setStyleCSS(BOrd.make(htmlFolder + "/css/style.css"));
        setCustomCssFile(BOrd.make(htmlFolder + "/css/custom.css"));


        Date date = new Date();
        System.out.println("HTML Generation started at: " + date);



        //Build Equip List
        BOrd EquipFileOrd = getEquipHTML();
        BIFile equipFile = null;
        String equipMenuName = getEquipListName();



        if (getHasEquipment() == true) {
            if (this.getSlot("EquipmentList") == null) {
                this.add("EquipmentList", new BEquipmentList());
            }
            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries = EquipFileOrd.parse();
                FilePath filePath = (FilePath) queries[queries.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                equipFile = BFileSystem.INSTANCE.makeFile(filePath);
                File localFile = BFileSystem.INSTANCE.pathToLocalFile(filePath);
                FileWriter fw = new FileWriter(localFile, false);
                fw.write("<li id=\"equipMenu\" class><a href='#'><span>" + equipMenuName + " ▼</span></a><ul >");
                fw.close();
                System.out.println("Success writing to " + EquipFileOrd.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault
                System.out.println("Error writing to " + EquipFileOrd.toString());
            }


            // Query for sensor components
            String parentName = getName();

            BOrd query = BOrd.make("station:|slot:/|bql:select equipName, equipPath from nhtml:EquipmentNavItem where parent.parent.name = '" + parentName + "'");
            String equipNavName = "";
            String equipPath = "";


            //attempt to locate the file
            try {
                equipFile = (BIFile) EquipFileOrd.get(this);
            } catch (UnresolvedException e) {
                //do nothing
            }
            // Resolve our query to a Cursor and iterate through our
            // collection

            BITable table = (BITable) query.get();
            ColumnList columns = table.getColumns();

            try (TableCursor<BIObject> cursor = table.cursor()) {
                int row = 0;
                while (cursor.next()) {


                    equipNavName = (cursor.cell(columns.get(0)).toString());
                    equipPath = (cursor.cell(columns.get(1)).toString());

                    try {
                        //if we are executing this code from a component in the station,
                        //we can resolve our query using the this keyword
                        FilePath filePath = equipFile.getFilePath();
                        File localFile = BFileSystem.INSTANCE.pathToLocalFile(filePath);
                        FileWriter fw = new FileWriter(localFile, true);
                        fw.write("<li><a target=\"hx\" href='" + equipPath + "'>");
                        fw.write("<span>" + equipNavName + "</span></a></li>");
                        fw.close();
                        System.out.println("Success writing to " + EquipFileOrd.toString());

                    }
                    //handle case where file isn't found or doesn't exist.
                    catch (UnresolvedException re) {

                    }
                    //handle IO exceptions from trying to write to the file
                    catch (IOException ioe) {

                    }

                }
                ++row;

            }
        } else {
            if (this.getSlot("EquipmentList") != null) {
                this.remove("EquipmentList");
            }

            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries = EquipFileOrd.parse();
                FilePath filePath = (FilePath) queries[queries.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                equipFile = BFileSystem.INSTANCE.makeFile(filePath);
                File localFile = BFileSystem.INSTANCE.pathToLocalFile(filePath);
                FileWriter fw = new FileWriter(localFile, false);
                fw.write("<li id=\"equipMenu\" style=\"display:none;\"");
                fw.close();
                System.out.println("Success writing to " + EquipFileOrd.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault

                System.out.println("Error writing to " + EquipFileOrd.toString());

            }
        }


        BOrd fileOrd2 = getCustomHTML();
        BIFile file2 = null;
        String customMenuName = getCustomListName();


        if (getHasCustomNavItem() == true) {
            if (this.getSlot("CustomList") == null) {
                this.add("CustomList", new BCustomList());
            }
            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries2 = fileOrd2.parse();
                FilePath filePath2 = (FilePath) queries2[queries2.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file2 = BFileSystem.INSTANCE.makeFile(filePath2);
                File localFile2 = BFileSystem.INSTANCE.pathToLocalFile(filePath2);
                FileWriter fw = new FileWriter(localFile2, false);
                fw.write("<li id=\"customMenu\" class><a href='#'><span>" + customMenuName + " ▼</span></a><ul>");
                fw.close();
                System.out.println("Success writing to " + fileOrd2.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault

                System.out.println("Error writing to " + fileOrd2.toString());

            }

            // Query for sensor components
            String parentName = getName();

            BOrd query2 = BOrd.make("station:|slot:/|bql:select customItemName, customItemPath from nhtml:CustomNavItem where parent.parent.name = '" + parentName + "'");
            String customNavName = "";
            String customPath = "";


            //attempt to locate the file
            try {
                file2 = (BIFile) fileOrd2.get(this);
            } catch (UnresolvedException e) {
                //do nothing
            }
            // Resolve our query to a Cursor and iterate through our
            // collection

            BITable table2 = (BITable) query2.get();
            ColumnList columns2 = table2.getColumns();

            try (TableCursor<BIObject> cursor2 = table2.cursor()) {
                int row = 0;
                while (cursor2.next()) {


                    customNavName = (cursor2.cell(columns2.get(0)).toString());
                    customPath = (cursor2.cell(columns2.get(1)).toString());

                    try {
                        //if we are executing this code from a component in the station,
                        //we can resolve our query using the this keyword
                        FilePath filePath2 = file2.getFilePath();
                        File localFile2 = BFileSystem.INSTANCE.pathToLocalFile(filePath2);
                        FileWriter fw = new FileWriter(localFile2, true);
                        fw.write("<li><a target=\"hx\" href='" + customPath + "'>");
                        fw.write("<span>" + customNavName + "</span></a></li>");
                        fw.close();
                        System.out.println("Success writing to " + fileOrd2.toString());

                    }
                    //handle case where file isn't found or doesn't exist.
                    catch (UnresolvedException re) {

                    }
                    //handle IO exceptions from trying to write to the file
                    catch (IOException ioe) {

                    }

                }
                ++row;

            }
        } else {
            if (this.getSlot("CustomList") != null) {
                this.remove("CustomList");
            }
            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries2 = fileOrd2.parse();
                FilePath filePath2 = (FilePath) queries2[queries2.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file2 = BFileSystem.INSTANCE.makeFile(filePath2);
                File localFile2 = BFileSystem.INSTANCE.pathToLocalFile(filePath2);
                FileWriter fw = new FileWriter(localFile2, false);
                fw.write("<li id=\"customMenu\" style=\"display:none;\"");
                fw.close();
                System.out.println("Success writing to " + fileOrd2.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault

                System.out.println("Error writing to " + fileOrd2.toString());

            }
        }

        BOrd fileOrd3 = getFloorplanHTML();
        BIFile file3 = null;
        String floorplanMenuName = getFloorplanListName();


        if (getHasFloorplans() == true) {
            if (this.getSlot("FloorplanList") == null) {
                this.add("FloorplanList", new BFloorplanList());
            }

            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries3 = fileOrd3.parse();
                FilePath filePath3 = (FilePath) queries3[queries3.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file3 = BFileSystem.INSTANCE.makeFile(filePath3);
                File localFile3 = BFileSystem.INSTANCE.pathToLocalFile(filePath3);
                FileWriter fw = new FileWriter(localFile3, false);
                fw.write("<li id=\"floorplanMenu\" class><a href='#'><span>" + floorplanMenuName + " ▼</span></a><ul>");

                fw.close();
                System.out.println("Success writing to " + fileOrd3.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault

                System.out.println("Error writing to " + fileOrd3.toString());

            }

            // Query for sensor components
            String parentName = getName();
            BOrd query3 = BOrd.make("station:|slot:/|bql:select floorplanName, floorplanPath from nhtml:FloorplanNavItem where parent.parent.name = '" + parentName + "'");
            String floorplanNavName = "";
            String floorplanPath = "";


            //attempt to locate the file
            try {
                file3 = (BIFile) fileOrd3.get(this);
            } catch (UnresolvedException e) {
                //do nothing
            }
            // Resolve our query to a Cursor and iterate through our
            // collection
            BITable table3 = (BITable) query3.get();
            ColumnList columns3 = table3.getColumns();


            try (TableCursor<BIObject> cursor3 = table3.cursor()) {
                int row = 0;
                while (cursor3.next()) {


                    floorplanNavName = (cursor3.cell(columns3.get(0)).toString());
                    floorplanPath = (cursor3.cell(columns3.get(1)).toString());

                    try {
                        //if we are executing this code from a component in the station,
                        //we can resolve our query using the this keyword
                        FilePath filePath3 = file3.getFilePath();
                        File localFile3 = BFileSystem.INSTANCE.pathToLocalFile(filePath3);
                        FileWriter fw = new FileWriter(localFile3, true);
                        fw.write("<li><a target=\"hx\" href='" + floorplanPath + "'>");
                        fw.write("<span>" + floorplanNavName + "</span></a></li>");
                        fw.close();
                        System.out.println("Success writing to " + fileOrd3.toString());

                    }
                    //handle case where file isn't found or doesn't exist.
                    catch (UnresolvedException re) {

                    }
                    //handle IO exceptions from trying to write to the file
                    catch (IOException ioe) {

                    }

                }
                ++row;

            }
        } else {
            if (this.getSlot("FloorplanList") != null) {
                this.remove("FloorplanList");
            }


            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries3 = fileOrd3.parse();
                FilePath filePath3 = (FilePath) queries3[queries3.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file3 = BFileSystem.INSTANCE.makeFile(filePath3);
                File localFile3 = BFileSystem.INSTANCE.pathToLocalFile(filePath3);
                FileWriter fw = new FileWriter(localFile3, false);
                fw.write("<li id=\"floorplanMenu\" style=\"display:none;\"</li>");
                fw.close();
                System.out.println("Success writing to " + fileOrd3.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault
                System.out.println("Error writing to " + fileOrd3.toString());
            }


        }


        BOrd fileOrd5 = getLogoCSS();
        BIFile file5 = null;
        double minWidth = getMinLogoWidth();
        double maxWidth = getMaxLogoWidth();
        double topPadding = getLogoTopPadding();


        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queries5 = fileOrd5.parse();
            FilePath filePath5 = (FilePath) queries5[queries5.length - 1];
            // Once we have the FilePath, we use it to create the file.
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            file5 = BFileSystem.INSTANCE.makeFile(filePath5);
            File localFile5 = BFileSystem.INSTANCE.pathToLocalFile(filePath5);
            FileWriter fw = new FileWriter(localFile5, false);
            fw.write("#logo{width: 100%;max-width:" + maxWidth + "px;min-width:" + minWidth + "px;margin-top:" + topPadding + "px;}");
            fw.close();
            System.out.println("Success writing to " + fileOrd5.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault

            System.out.println("Error writing to " + fileOrd5.toString());

        }

        BOrd fileOrd6 = getNavCSS();
        BIFile file6 = null;
        String navColor = getNavColor().toString();


        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queries6 = fileOrd6.parse();
            FilePath filePath6 = (FilePath) queries6[queries6.length - 1];
            // Once we have the FilePath, we use it to create the file.
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            file6 = BFileSystem.INSTANCE.makeFile(filePath6);
            File localFile6 = BFileSystem.INSTANCE.pathToLocalFile(filePath6);
            FileWriter fw = new FileWriter(localFile6, false);
            fw.write("#cssmenu{background:" + navColor + "}");
            fw.close();
            System.out.println("Success writing to " + fileOrd6.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault

            System.out.println("Error writing to " + fileOrd6.toString());

        }

        BOrd fileOrdCustomCss = getCustomCssFile();
        BIFile fileCustomCss  = null;
        String customCss = getCustomCss();

        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queriesCustomCss  = fileOrdCustomCss.parse();
            FilePath filePathCustomCss  = (FilePath) queriesCustomCss[queriesCustomCss.length - 1];
            // Once we have the FilePath, we use it to create the file.
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            fileCustomCss = BFileSystem.INSTANCE.makeFile(filePathCustomCss);
            File localFilefileCustomCss = BFileSystem.INSTANCE.pathToLocalFile(filePathCustomCss);
            FileWriter fw = new FileWriter(localFilefileCustomCss, false);
            fw.write(customCss);
            fw.close();
            System.out.println("Success writing to " + fileOrdCustomCss.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault

            System.out.println("Error writing to " + fileOrdCustomCss.toString());

        }


        BOrd fileOrd9 = getExternalHTML();
        BIFile file9 = null;
        String externalPath = getExternalLinkPath();
        String externalLinkName = getExternalLinkName();


        if (getHasExternalLink() == true) {

            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries9 = fileOrd9.parse();
                FilePath filePath9 = (FilePath) queries9[queries9.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file9 = BFileSystem.INSTANCE.makeFile(filePath9);
                File localFile9 = BFileSystem.INSTANCE.pathToLocalFile(filePath9);
                FileWriter fw = new FileWriter(localFile9, false);
                fw.write("<li id=\"externalLink\" class><a target=\"_blank\" href='" + externalPath + "'><span>" + externalLinkName + "</span></a><ul >");
                fw.close();
                System.out.println("Success writing to " + fileOrd9.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault
                System.out.println("Error writing to " + fileOrd9.toString());
            }
        } else {
            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries9 = fileOrd9.parse();
                FilePath filePath9 = (FilePath) queries9[queries9.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file9 = BFileSystem.INSTANCE.makeFile(filePath9);
                File localFile9 = BFileSystem.INSTANCE.pathToLocalFile(filePath9);
                FileWriter fw = new FileWriter(localFile9, false);
                fw.write("<li id=\"externalLink\" style=\"display:none;\"</li>");
                fw.close();
                System.out.println("Success writing to " + fileOrd9.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault
                System.out.println("Error writing to " + fileOrd9.toString());
            }
        }

        BOrd fileOrd13 = getNavFile();
        BIFile file13 = null;


        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queries13 = fileOrd13.parse();
            FilePath filePath13 = (FilePath) queries13[queries13.length - 1];
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            file13 = BFileSystem.INSTANCE.makeFile(filePath13);
            File localFile13 = BFileSystem.INSTANCE.pathToLocalFile(filePath13);
            FileWriter fw = new FileWriter(localFile13, false);
            fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <nav version='1.0'> <node name='Home' ord='station:|slot:" + this.toPathString() + "|view:nhtml:Nhtml' icon='module://icons/x16/home.png'/></nav>");
            fw.close();
            System.out.println("Success writing to " + fileOrd13.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault
            System.out.println("Error writing to " + fileOrd13.toString());
        }

        //use an ORD to retrieve our starting file
        BOrd bajascriptFileQuery =  BOrd.make("module://nhtml/html5/js/bajascript.js");
        //use a try catch block in case the file doesn't exist
        String alarmConsoleName1 = getAlarmConsoleName();
        String notificationConsoleName1 = getNotificationConsoleName();
        try
        {
            //if we are executing this code from a component in the station,
            //we can resolve our query using the this keyword
            BIFile myBajascriptFile = (BIFile)bajascriptFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader bajascriptIn = new InputStreamReader( myBajascriptFile.getInputStream() );

            //create a try/finally block to force input stream is always closed.
            try
            {
                //use the input stream and create a buffered reader to read
                //each line
                BufferedReader bajascriptBin = new BufferedReader( bajascriptIn );
                BOrd bajascriptFileOrd = getBajascriptJs();
                BIFile bajascriptFile = null;
                OrdQuery[] queriesBajascript = bajascriptFileOrd.parse();
                FilePath bajascriptFilePath = (FilePath) queriesBajascript[queriesBajascript.length - 1];
                bajascriptFile = BFileSystem.INSTANCE.makeFile(bajascriptFilePath);
                File bajascriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(bajascriptFilePath);
                FileWriter bajascriptFw = new FileWriter(bajascriptLocalFile, false);
                bajascriptFw.write("");
                bajascriptFw.close();
                String str;
                while( ( str = bajascriptBin.readLine() ) != null )
                {
                    //do something with our string ...


                    String serviceName = getName();
                    System.out.println("Reading bajascript.js");
                    String str2 = str.replace("serviceName", serviceName).replace("notificationConsoleName", notificationConsoleName1).replace("alarmConsoleName", alarmConsoleName1);
                    System.out.println("Replacing paths");


                    try { // Parse the file ORD to retrieve the FilePath. We can safely
                        // assume the FilePath is the last sub query of the full ORD.

                        FileWriter bajascriptFw2 = new FileWriter(bajascriptLocalFile, true);
                        bajascriptFw2.write(str2 +"\n");
                        bajascriptFw2.close();
                        System.out.println("Success writing line to" + bajascriptFileOrd.toString());


                    } catch (Exception e) // Indicates problem creating file
                    { // Call configFail() to set the service into fault
                        System.out.println("Error writing to " + bajascriptFileOrd.toString());
                    }

                }

            }
            //make sure to close the input stream
            finally
            {
                bajascriptIn.close();
            }

        }
//handle case where file isn't found or doesn't exist.
        catch(UnresolvedException re)
        {
            System.out.println("Error reading " + bajascriptFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch(IOException ioe)
        {
            System.out.println("Error reading " + bajascriptFileQuery);
        }







        String schedulePath = null;
        String logoPath = getLogoPath().toString();
        String siteTitle = getSiteTitle();
        String homePagePath = getHomePagePath().toString();
        String alarmConsolePath = getAlarmConsolePath().toString();
        String notifConsolePath = getNotificationConsolePath().toString();
        String entSecMenu = "";
        String docMenu = "";
        String reportMenu = "";
        String historiesMenu = "";
        String schedulesMenu = "";
        String notificationMenu = "";
        String alarmMenu = "";


        if (getHasEntSec() == true) {
            schedulePath = "station:|slot:/Services/EnterpriseSecurityService/schedules";
            entSecMenu = "<li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService'><span>Access Control ▼</span></a><ul><li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService/personnel'><span>People</span></a></li>" +
                    "<li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService/badges'><span>Badges</span></a></li><li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService/accessRights'><span>Access Rights</span></a></li>" +
                    "<li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService/accessHistory'><span>Access History</span></a></li></ul></li>";
        } else {
            schedulePath = getSchedulePagePath().toString();
            entSecMenu = "";
        }
        if (getShowDocs() == true) {
            docMenu = "<li><a target=\"hx\" href='file:^docs'><span>Documents</span></a></li>";
        } else {
            docMenu = "";
        }
        if (getShowReports() == true) {
            reportMenu = "<li class><a href='#'><span>Reports ▼</span></a><ul> <li class><a target=\"hx\" href='station:|slot:/Graphics/Reports/Active$20Overrides'><span>Active Overrides</span></a></li>" +
                    "<li class><a target=\"hx\" href='station:|slot:/Graphics/Reports/Override$20Report$20$28last$207$20days$29'><span>Audit Log (last 7 days)</span></a></li></ul></li>";
        } else {
            reportMenu = "";
        }
        if (getShowHistories() == true) {
            historiesMenu = "<li><a target=\"hx\" href='history:|view:webChart:ChartWidget'><span>Histories</span></a></li>";
        } else {
            historiesMenu = "";
        }
        if (getShowSchedules() == true) {
            schedulesMenu = "<li class><a target=\"hx\" href='" + schedulePath + "'><span>Schedules</span></a></li>";
        } else {
            schedulesMenu = "";
        }
        if (getHasNotificationConsole() == true) {
            notificationMenu = "<li id=\"Notifications\"><a id=\"NotificationConsoleLink\" target=\"hx\" href=\"" + notifConsolePath + "\"><span id=\"AllNotifications\" class=\"AllNotifications\" >Notification Count loading..</span></a></li>";
        } else {
            notificationMenu = "";
        }
        if (getHasAlarmConsole() == true) {
            alarmMenu = "<li class='last' id=\"Alarms\"><a id=\"AlarmConsoleLink\" target=\"hx\" href=\"" + alarmConsolePath + "\"><span id=\"AllAlarms\" class=\"AllAlarms\" >Alarm Count loading..</span></a></li>";
        } else {
            alarmMenu = "";
        }





        //use an ORD to retrieve our starting file
        BOrd scriptFileQuery =  BOrd.make("module://nhtml/html5/js/script.js");
        //use a try catch block in case the file doesn't exist
        try
        {
            //if we are executing this code from a component in the station,
            //we can resolve our query using the this keyword
            BIFile myScriptFile = (BIFile)scriptFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader scriptIn = new InputStreamReader( myScriptFile.getInputStream() );

            //create a try/finally block to force input stream is always closed.
            try
            {
                //use the input stream and create a buffered reader to read
                //each line
                BufferedReader scriptBin = new BufferedReader( scriptIn );
                BOrd scriptFileOrd = getScriptJS();
                BIFile scriptFile = null;
                // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queriesScript = scriptFileOrd.parse();
                FilePath scriptFilePath = (FilePath) queriesScript[queriesScript.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                scriptFile = BFileSystem.INSTANCE.makeFile(scriptFilePath);
                File scriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(scriptFilePath);
                FileWriter scriptFw = new FileWriter(scriptLocalFile, false);
                scriptFw.write("");
                scriptFw.close();
                System.out.println("Success writing line to" + scriptFileOrd.toString());
                String str;
                while( ( str = scriptBin.readLine() ) != null )
                {
                    //do something with our string ...


                    System.out.println("Reading script.js");

                    try {
                        FileWriter scriptFw2 = new FileWriter(scriptLocalFile, true);
                        scriptFw2.write(str +"\n");
                        scriptFw2.close();
                        System.out.println("Success writing line to" + scriptFileOrd.toString());


                    } catch (Exception e) // Indicates problem creating file
                    { // Call configFail() to set the service into fault
                        System.out.println("Error writing to " + scriptFileOrd.toString());
                    }

                }

            }
            //make sure to close the input stream
            finally
            {
                scriptIn.close();
            }

        }
//handle case where file isn't found or doesn't exist.
        catch(UnresolvedException re)
        {
            System.out.println("Error reading " + scriptFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch(IOException ioe)
        {
            System.out.println("Error reading " + scriptFileQuery);
        }









        //use an ORD to retrieve our starting file
        BOrd cssFileQuery =  BOrd.make("module://nhtml/html5/css/style.css");
        //use a try catch block in case the file doesn't exist
        try
        {
            //if we are executing this code from a component in the station,
            //we can resolve our query using the this keyword
            BIFile myCssFile = (BIFile)cssFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader cssIn = new InputStreamReader( myCssFile.getInputStream() );

            //create a try/finally block to force input stream is always closed.
            try
            {
                //use the input stream and create a buffered reader to read
                //each line
                BufferedReader cssBin = new BufferedReader( cssIn );
                BOrd cssFileOrd = getStyleCSS();
                BIFile cssFile = null;
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queriesCss = cssFileOrd.parse();
                FilePath cssFilePath = (FilePath) queriesCss[queriesCss.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                cssFile = BFileSystem.INSTANCE.makeFile(cssFilePath);
                File cssLocalFile = BFileSystem.INSTANCE.pathToLocalFile(cssFilePath);
                FileWriter cssFw = new FileWriter(cssLocalFile, false);
                cssFw.write("");
                cssFw.close();
                System.out.println("Success clearing " + cssFileOrd.toString());

                System.out.println("Success writing line to" + cssFileOrd.toString());

                String str;
                while( ( str = cssBin.readLine() ) != null )
                {
                    //do something with our string ...



                    System.out.println("Reading CSS");

                    try {
                        FileWriter cssFw2 = new FileWriter(cssLocalFile, true);
                        cssFw2.write(str +"\n");
                        cssFw2.close();
                        System.out.println("Success writing line to" + cssFileOrd.toString());


                    } catch (Exception e) // Indicates problem creating file
                    { // Call configFail() to set the service into fault
                        System.out.println("Error writing to " + cssFileOrd.toString());
                    }

                }

            }
            //make sure to close the input stream
            finally
            {
                cssIn.close();
            }

        }
//handle case where file isn't found or doesn't exist.
        catch(UnresolvedException re)
        {
            System.out.println("Error reading " + cssFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch(IOException ioe)
        {
            System.out.println("Error reading " + cssFileQuery);
        }




        //use an ORD to retrieve our starting file
        BOrd htmlFileQuery =  BOrd.make("module://nhtml/html5/html/index.html");
       //use a try catch block in case the file doesn't exist
        try
        {
            //if we are executing this code from a component in the station,
            //we can resolve our query using the this keyword
            BIFile myHtmlFile = (BIFile)htmlFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader htmlIn = new InputStreamReader( myHtmlFile.getInputStream() );

            //create a try/finally block to force input stream is always closed.
            try
            {
                //use the input stream and create a buffered reader to read
                //each line
                BufferedReader htmlBin = new BufferedReader( htmlIn );
                BOrd htmlFileOrd = getIndexHTML();
                BIFile htmlFile = null;
                // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queriesHtml = htmlFileOrd.parse();
                FilePath htmlFilePath = (FilePath) queriesHtml[queriesHtml.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                htmlFile = BFileSystem.INSTANCE.makeFile(htmlFilePath);
                File localHtmlFile = BFileSystem.INSTANCE.pathToLocalFile(htmlFilePath);
                FileWriter fw = new FileWriter(localHtmlFile, false);
                fw.write("");
                fw.close();
                System.out.println("Success writing line to " + htmlFileOrd.toString());
                String str;
                while( ( str = htmlBin.readLine() ) != null )
                {
                    //do something with our string ...


                    System.out.println("Reading HTML");

                    String str2 = str.replace("homePagePath", homePagePath).replace("logoPath", logoPath).replace("historiesMenu",historiesMenu).replace("schedulesMenu",schedulesMenu).replace("reportMenu",reportMenu).replace("docMenu",docMenu).replace("notificationMenu",notificationMenu).replace("alarmMenu",alarmMenu).replace("entSecMenu",entSecMenu);
                    System.out.println("Replacing Paths");
                    try {
                        FileWriter htmlFw2 = new FileWriter(localHtmlFile, true);
                        htmlFw2.write(str2 +"\n");
                        htmlFw2.close();
                        System.out.println("Success writing line to " + htmlFileOrd.toString());


                    } catch (Exception e) // Indicates problem creating file
                    { // Call configFail() to set the service into fault
                        System.out.println("Error writing to " + htmlFileOrd.toString());
                    }

                }

            }
            //make sure to close the input stream
            finally
            {
                htmlIn.close();
            }

        }
//handle case where file isn't found or doesn't exist.
        catch(UnresolvedException re)
        {
            System.out.println("Error reading " + htmlFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch(IOException ioe)
        {
            System.out.println("Error reading " + htmlFileQuery);
        }

        System.out.println("HTML Generation completed at: " + date);
        String currentDate = date.toString();
        setHtmlLastGenerated(currentDate);


    }

    public AgentList getAgents(Context cx) {
        AgentList list = super.getAgents(cx);
        list.toBottom("nhtml:Nhtml");
        return list;
    }


    @Override
    public BIcon getIcon() {
        return BIcon.make("module://nhtml/icons/html.png");
    }
}









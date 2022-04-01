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
        name = "alarmJs",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/js/alarms.js\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "notificationsJs",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/js/notifications.js\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "usernameJs",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/js/username.js\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "oahJs",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/js/oah.js\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "oatJs",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/js/oat.js\")",
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
        name = "externalListHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/externallist.html\")",
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
        defaultValue = "false"
)
@NiagaraProperty(
        name = "oat",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Global/OAT\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }

)
@NiagaraProperty(
        name = "hasOah",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "oah",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Global/OAH\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
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
        name = "hasExternalList",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
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
        name = "externalWaveSyncLink",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
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
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Services/AlarmService/NotificationCount\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
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
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Services/AlarmService/AlarmCount\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
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
/*@ $com.kvg.nhtml.BHTML5(2388557279)1.0$ @*/
/* Generated Thu Mar 31 13:39:53 BOT 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Property "alarmJs"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmJs} property.
   * @see #getAlarmJs
   * @see #setAlarmJs
   */
  public static final Property alarmJs = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/js/alarms.js"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code alarmJs} property.
   * @see #alarmJs
   */
  public BOrd getAlarmJs() { return (BOrd)get(alarmJs); }
  
  /**
   * Set the {@code alarmJs} property.
   * @see #alarmJs
   */
  public void setAlarmJs(BOrd v) { set(alarmJs, v, null); }

////////////////////////////////////////////////////////////////
// Property "notificationsJs"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code notificationsJs} property.
   * @see #getNotificationsJs
   * @see #setNotificationsJs
   */
  public static final Property notificationsJs = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/js/notifications.js"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code notificationsJs} property.
   * @see #notificationsJs
   */
  public BOrd getNotificationsJs() { return (BOrd)get(notificationsJs); }
  
  /**
   * Set the {@code notificationsJs} property.
   * @see #notificationsJs
   */
  public void setNotificationsJs(BOrd v) { set(notificationsJs, v, null); }

////////////////////////////////////////////////////////////////
// Property "usernameJs"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code usernameJs} property.
   * @see #getUsernameJs
   * @see #setUsernameJs
   */
  public static final Property usernameJs = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/js/username.js"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code usernameJs} property.
   * @see #usernameJs
   */
  public BOrd getUsernameJs() { return (BOrd)get(usernameJs); }
  
  /**
   * Set the {@code usernameJs} property.
   * @see #usernameJs
   */
  public void setUsernameJs(BOrd v) { set(usernameJs, v, null); }

////////////////////////////////////////////////////////////////
// Property "oahJs"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code oahJs} property.
   * @see #getOahJs
   * @see #setOahJs
   */
  public static final Property oahJs = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/js/oah.js"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code oahJs} property.
   * @see #oahJs
   */
  public BOrd getOahJs() { return (BOrd)get(oahJs); }
  
  /**
   * Set the {@code oahJs} property.
   * @see #oahJs
   */
  public void setOahJs(BOrd v) { set(oahJs, v, null); }

////////////////////////////////////////////////////////////////
// Property "oatJs"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code oatJs} property.
   * @see #getOatJs
   * @see #setOatJs
   */
  public static final Property oatJs = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/js/oat.js"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code oatJs} property.
   * @see #oatJs
   */
  public BOrd getOatJs() { return (BOrd)get(oatJs); }
  
  /**
   * Set the {@code oatJs} property.
   * @see #oatJs
   */
  public void setOatJs(BOrd v) { set(oatJs, v, null); }

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
// Property "externalListHTML"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code externalListHTML} property.
   * @see #getExternalListHTML
   * @see #setExternalListHTML
   */
  public static final Property externalListHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/externallist.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code externalListHTML} property.
   * @see #externalListHTML
   */
  public BOrd getExternalListHTML() { return (BOrd)get(externalListHTML); }
  
  /**
   * Set the {@code externalListHTML} property.
   * @see #externalListHTML
   */
  public void setExternalListHTML(BOrd v) { set(externalListHTML, v, null); }

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
  public static final Property hasOat = newProperty(Flags.SUMMARY, false, null);
  
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
  public static final Property oat = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Global/OAT"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code oat} property.
   * @see #oat
   */
  public BOrd getOat() { return (BOrd)get(oat); }
  
  /**
   * Set the {@code oat} property.
   * @see #oat
   */
  public void setOat(BOrd v) { set(oat, v, null); }

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
  public static final Property oah = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Global/OAH"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code oah} property.
   * @see #oah
   */
  public BOrd getOah() { return (BOrd)get(oah); }
  
  /**
   * Set the {@code oah} property.
   * @see #oah
   */
  public void setOah(BOrd v) { set(oah, v, null); }

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
// Property "hasExternalList"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hasExternalList} property.
   * @see #getHasExternalList
   * @see #setHasExternalList
   */
  public static final Property hasExternalList = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code hasExternalList} property.
   * @see #hasExternalList
   */
  public boolean getHasExternalList() { return getBoolean(hasExternalList); }
  
  /**
   * Set the {@code hasExternalList} property.
   * @see #hasExternalList
   */
  public void setHasExternalList(boolean v) { setBoolean(hasExternalList, v, null); }

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
// Property "externalWaveSyncLink"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code externalWaveSyncLink} property.
   * @see #getExternalWaveSyncLink
   * @see #setExternalWaveSyncLink
   */
  public static final Property externalWaveSyncLink = newProperty(Flags.SUMMARY, false, null);
  
  /**
   * Get the {@code externalWaveSyncLink} property.
   * @see #externalWaveSyncLink
   */
  public boolean getExternalWaveSyncLink() { return getBoolean(externalWaveSyncLink); }
  
  /**
   * Set the {@code externalWaveSyncLink} property.
   * @see #externalWaveSyncLink
   */
  public void setExternalWaveSyncLink(boolean v) { setBoolean(externalWaveSyncLink, v, null); }

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
  public static final Property notificationCount = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Services/AlarmService/NotificationCount"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code notificationCount} property.
   * @see #notificationCount
   */
  public BOrd getNotificationCount() { return (BOrd)get(notificationCount); }
  
  /**
   * Set the {@code notificationCount} property.
   * @see #notificationCount
   */
  public void setNotificationCount(BOrd v) { set(notificationCount, v, null); }

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
  public static final Property alarmCount = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Services/AlarmService/AlarmCount"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code alarmCount} property.
   * @see #alarmCount
   */
  public BOrd getAlarmCount() { return (BOrd)get(alarmCount); }
  
  /**
   * Set the {@code alarmCount} property.
   * @see #alarmCount
   */
  public void setAlarmCount(BOrd v) { set(alarmCount, v, null); }

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
        setExternalListHTML(BOrd.make(htmlFolder + "/externallist.html"));
        setFloorplanHTML(BOrd.make(htmlFolder + "/floorplans.html"));
        setIndexHTML(BOrd.make(htmlFolder + "/index.html"));
        setNavFile(BOrd.make(htmlFolder + "/nav/nav.nav"));
        setAlarmJs(BOrd.make(htmlFolder + "/js/alarms.js"));
        setNotificationsJs(BOrd.make(htmlFolder + "/js/notifications.js"));
        setUsernameJs(BOrd.make(htmlFolder + "/js/username.js"));
        setOahJs(BOrd.make(htmlFolder + "/js/oah.js"));
        setOatJs(BOrd.make(htmlFolder + "/js/oat.js"));
        setScriptJS(BOrd.make(htmlFolder + "/js/script.js"));
        setLogoCSS(BOrd.make(htmlFolder + "/css/logo.css"));
        setNavCSS(BOrd.make(htmlFolder + "/css/nav.css"));
        setStyleCSS(BOrd.make(htmlFolder + "/css/style.css"));
        setCustomCssFile(BOrd.make(htmlFolder + "/css/custom.css"));

        //get date
        Date date = new Date();
        System.out.println("HTML Generation started at: " + date);

        //when upgrading from old version remove this slot if it exists
        if (this.getSlot("bajascriptJs") != null) {
               this.remove("bajascriptJs");
               System.out.println("bajascriptJs removed");
         }

        //Build Equip List
        BOrd EquipFileOrd = getEquipHTML();
        BIFile equipFile = null;
        String equipMenuName = getEquipListName();


        if (getHasEquipment() == true) {
            if (this.getSlot("EquipmentList") == null) {
                this.add("EquipmentList", new BEquipmentList());
            }
            try {
                OrdQuery[] queries = EquipFileOrd.parse();
                FilePath filePath = (FilePath) queries[queries.length - 1];
                equipFile = BFileSystem.INSTANCE.makeFile(filePath);
                File localFile = BFileSystem.INSTANCE.pathToLocalFile(filePath);
                FileWriter fw = new FileWriter(localFile, false);
                fw.write("<li id=\"equipMenu\" class><a href='#'><span>" + equipMenuName + " ▼</span></a><ul >");
                fw.close();
                System.out.println("Success writing to " + EquipFileOrd.toString());

            } catch (Exception e)
            {
                System.out.println("Error writing to " + EquipFileOrd.toString());
            }
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

            try {

                OrdQuery[] queries = EquipFileOrd.parse();
                FilePath filePath = (FilePath) queries[queries.length - 1];



                equipFile = BFileSystem.INSTANCE.makeFile(filePath);
                File localFile = BFileSystem.INSTANCE.pathToLocalFile(filePath);
                FileWriter fw = new FileWriter(localFile, false);
                fw.write("<li id=\"equipMenu\" style=\"display:none;\"");
                fw.close();
                System.out.println("Success writing to " + EquipFileOrd.toString());


            } catch (Exception e)
            {

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
            try {

                OrdQuery[] queries2 = fileOrd2.parse();
                FilePath filePath2 = (FilePath) queries2[queries2.length - 1];



                file2 = BFileSystem.INSTANCE.makeFile(filePath2);
                File localFile2 = BFileSystem.INSTANCE.pathToLocalFile(filePath2);
                FileWriter fw = new FileWriter(localFile2, false);
                fw.write("<li id=\"customMenu\" class><a href='#'><span>" + customMenuName + " ▼</span></a><ul>");
                fw.close();
                System.out.println("Success writing to " + fileOrd2.toString());


            } catch (Exception e)
            {

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
            try {

                OrdQuery[] queries2 = fileOrd2.parse();
                FilePath filePath2 = (FilePath) queries2[queries2.length - 1];



                file2 = BFileSystem.INSTANCE.makeFile(filePath2);
                File localFile2 = BFileSystem.INSTANCE.pathToLocalFile(filePath2);
                FileWriter fw = new FileWriter(localFile2, false);
                fw.write("<li id=\"customMenu\" style=\"display:none;\"");
                fw.close();
                System.out.println("Success writing to " + fileOrd2.toString());


            } catch (Exception e)
            {

                System.out.println("Error writing to " + fileOrd2.toString());

            }
        }




        //start

        BOrd fileOrd33 = getExternalListHTML();
        BIFile file33 = null;


        if (getHasExternalList() == true) {
            if (this.getSlot("ExternalList") == null) {
                this.add("ExternalList", new BExternalList());
            }
            try {

                OrdQuery[] queries33 = fileOrd33.parse();
                FilePath filePath33 = (FilePath) queries33[queries33.length - 1];



                file33 = BFileSystem.INSTANCE.makeFile(filePath33);
                File localFile33 = BFileSystem.INSTANCE.pathToLocalFile(filePath33);
                FileWriter fw = new FileWriter(localFile33, false);
                fw.write("<li id=\"externalMenu\" class><a href='#'><span>External Links ▼</span></a><ul>");
                fw.close();
                System.out.println("Success writing to " + fileOrd33.toString());


            } catch (Exception e)
            {

                System.out.println("Error writing to " + fileOrd33.toString());

            }

            // Query for sensor components
            String parentName = getName();

            BOrd query33 = BOrd.make("station:|slot:/|bql:select externalLinkName, externalLinkPath from nhtml:ExternalLinkItem where parent.parent.name = '" + parentName + "'");
            String externalLinkName = "";
            String externalLinkPath = "";


            //attempt to locate the file
            try {
                file33 = (BIFile) fileOrd33.get(this);
            } catch (UnresolvedException e) {
                //do nothing
            }
            // Resolve our query to a Cursor and iterate through our
            // collection

            BITable table33 = (BITable) query33.get();
            ColumnList columns33 = table33.getColumns();

            try (TableCursor<BIObject> cursor33 = table33.cursor()) {
                int row = 0;
                while (cursor33.next()) {


                    externalLinkName = (cursor33.cell(columns33.get(0)).toString());
                    externalLinkPath = (cursor33.cell(columns33.get(1)).toString());

                    try {


                        FilePath filePath33 = file33.getFilePath();
                        File localFile33 = BFileSystem.INSTANCE.pathToLocalFile(filePath33);
                        FileWriter fw = new FileWriter(localFile33, true);
                        fw.write("<li><a target=\"_blank\" href='" + externalLinkPath + "'>");
                        fw.write("<span>" + externalLinkName + "</span></a></li>");
                        fw.close();
                        System.out.println("Success writing to " + fileOrd33.toString());

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
            if (this.getSlot("ExternalList") != null) {
                this.remove("ExternalList");
            }
            try {

                OrdQuery[] queries33 = fileOrd33.parse();
                FilePath filePath33 = (FilePath) queries33[queries33.length - 1];



                file33 = BFileSystem.INSTANCE.makeFile(filePath33);
                File localFile33 = BFileSystem.INSTANCE.pathToLocalFile(filePath33);
                FileWriter fw = new FileWriter(localFile33, false);
                fw.write("<li id=\"externalMenu\" style=\"display:none;\"");
                fw.close();
                System.out.println("Success writing to " + fileOrd33.toString());


            } catch (Exception e)
            {

                System.out.println("Error writing to " + fileOrd33.toString());

            }
        }











        //end

        BOrd fileOrd3 = getFloorplanHTML();
        BIFile file3 = null;
        String floorplanMenuName = getFloorplanListName();


        if (getHasFloorplans() == true) {
            if (this.getSlot("FloorplanList") == null) {
                this.add("FloorplanList", new BFloorplanList());
            }

            try {

                OrdQuery[] queries3 = fileOrd3.parse();
                FilePath filePath3 = (FilePath) queries3[queries3.length - 1];



                file3 = BFileSystem.INSTANCE.makeFile(filePath3);
                File localFile3 = BFileSystem.INSTANCE.pathToLocalFile(filePath3);
                FileWriter fw = new FileWriter(localFile3, false);
                fw.write("<li id=\"floorplanMenu\" class><a href='#'><span>" + floorplanMenuName + " ▼</span></a><ul>");

                fw.close();
                System.out.println("Success writing to " + fileOrd3.toString());


            } catch (Exception e)
            {

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


            try {

                OrdQuery[] queries3 = fileOrd3.parse();
                FilePath filePath3 = (FilePath) queries3[queries3.length - 1];



                file3 = BFileSystem.INSTANCE.makeFile(filePath3);
                File localFile3 = BFileSystem.INSTANCE.pathToLocalFile(filePath3);
                FileWriter fw = new FileWriter(localFile3, false);
                fw.write("<li id=\"floorplanMenu\" style=\"display:none;\"</li>");
                fw.close();
                System.out.println("Success writing to " + fileOrd3.toString());


            } catch (Exception e)
            {
                System.out.println("Error writing to " + fileOrd3.toString());
            }


        }


        BOrd fileOrd5 = getLogoCSS();
        BIFile file5 = null;
        double minWidth = getMinLogoWidth();
        double maxWidth = getMaxLogoWidth();
        double topPadding = getLogoTopPadding();


        try {

            OrdQuery[] queries5 = fileOrd5.parse();
            FilePath filePath5 = (FilePath) queries5[queries5.length - 1];



            file5 = BFileSystem.INSTANCE.makeFile(filePath5);
            File localFile5 = BFileSystem.INSTANCE.pathToLocalFile(filePath5);
            FileWriter fw = new FileWriter(localFile5, false);
            fw.write("#logo{width: 100%;max-width:" + maxWidth + "px;min-width:" + minWidth + "px;margin-top:" + topPadding + "px;}");
            fw.close();
            System.out.println("Success writing to " + fileOrd5.toString());


        } catch (Exception e)
        {

            System.out.println("Error writing to " + fileOrd5.toString());

        }

        BOrd fileOrd6 = getNavCSS();
        BIFile file6 = null;
        String navColor = getNavColor().toString();


        try {

            OrdQuery[] queries6 = fileOrd6.parse();
            FilePath filePath6 = (FilePath) queries6[queries6.length - 1];



            file6 = BFileSystem.INSTANCE.makeFile(filePath6);
            File localFile6 = BFileSystem.INSTANCE.pathToLocalFile(filePath6);
            FileWriter fw = new FileWriter(localFile6, false);
            fw.write("#cssmenu{background:" + navColor + "}");
            fw.close();
            System.out.println("Success writing to " + fileOrd6.toString());


        } catch (Exception e)
        {

            System.out.println("Error writing to " + fileOrd6.toString());

        }

        BOrd fileOrdCustomCss = getCustomCssFile();
        BIFile fileCustomCss = null;
        String customCss = getCustomCss();

        try {

            OrdQuery[] queriesCustomCss = fileOrdCustomCss.parse();
            FilePath filePathCustomCss = (FilePath) queriesCustomCss[queriesCustomCss.length - 1];



            fileCustomCss = BFileSystem.INSTANCE.makeFile(filePathCustomCss);
            File localFilefileCustomCss = BFileSystem.INSTANCE.pathToLocalFile(filePathCustomCss);
            FileWriter fw = new FileWriter(localFilefileCustomCss, false);
            fw.write(customCss);
            fw.close();
            System.out.println("Success writing to " + fileOrdCustomCss.toString());


        } catch (Exception e)
        {

            System.out.println("Error writing to " + fileOrdCustomCss.toString());

        }


        BOrd fileOrd9 = getExternalHTML();
        BIFile file9 = null;
        String externalPath = getExternalLinkPath();
        String externalLinkName = getExternalLinkName();


        if (getHasExternalLink() == true) {

            try {

                OrdQuery[] queries9 = fileOrd9.parse();
                FilePath filePath9 = (FilePath) queries9[queries9.length - 1];



                file9 = BFileSystem.INSTANCE.makeFile(filePath9);
                File localFile9 = BFileSystem.INSTANCE.pathToLocalFile(filePath9);
                FileWriter fw = new FileWriter(localFile9, false);
                fw.write("<li id=\"externalLink\" class><a target=\"_blank\" href='" + externalPath + "'><span>" + externalLinkName + "</span></a><ul >");
                fw.close();
                System.out.println("Success writing to " + fileOrd9.toString());


            } catch (Exception e)
            {
                System.out.println("Error writing to " + fileOrd9.toString());
            }
        } else {
            try {

                OrdQuery[] queries9 = fileOrd9.parse();
                FilePath filePath9 = (FilePath) queries9[queries9.length - 1];



                file9 = BFileSystem.INSTANCE.makeFile(filePath9);
                File localFile9 = BFileSystem.INSTANCE.pathToLocalFile(filePath9);
                FileWriter fw = new FileWriter(localFile9, false);
                fw.write("<li id=\"externalLink\" style=\"display:none;\"</li>");
                fw.close();
                System.out.println("Success writing to " + fileOrd9.toString());


            } catch (Exception e)
            {
                System.out.println("Error writing to " + fileOrd9.toString());
            }
        }

        BOrd fileOrd13 = getNavFile();
        BIFile file13 = null;


        try {

            OrdQuery[] queries13 = fileOrd13.parse();
            FilePath filePath13 = (FilePath) queries13[queries13.length - 1];


            file13 = BFileSystem.INSTANCE.makeFile(filePath13);
            File localFile13 = BFileSystem.INSTANCE.pathToLocalFile(filePath13);
            FileWriter fw = new FileWriter(localFile13, false);
            fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <nav version='1.0'> <node name='Home' ord='station:|slot:" + this.toPathString() + "|view:nhtml:Nhtml' icon='module://icons/x16/home.png'/></nav>");
            fw.close();
            System.out.println("Success writing to " + fileOrd13.toString());


        } catch (Exception e)
        {
            System.out.println("Error writing to " + fileOrd13.toString());
        }

        //use an ORD to retrieve our starting file
        BOrd alarmscriptFileQuery = BOrd.make("module://nhtml/html5/js/alarms.js");
        //use a try catch block in case the file doesn't exist
        String alarmConsoleName = getAlarmConsoleName();
        String alarmCountPath = getAlarmCount().toString();
        try {


            BIFile myAlarmscriptFile = (BIFile) alarmscriptFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader alarmscriptIn = new InputStreamReader(myAlarmscriptFile.getInputStream());
            if (getHasAlarmConsole() == true) {
                //create a try/finally block to force input stream is always closed.
                try {
                    //use the input stream and create a buffered reader to read
                    //each line
                    BufferedReader alarmscriptBin = new BufferedReader(alarmscriptIn);
                    BOrd alarmscriptFileOrd = getAlarmJs();
                    BIFile alarmscriptFile = null;
                    OrdQuery[] queriesAlarmscript = alarmscriptFileOrd.parse();
                    FilePath alarmscriptFilePath = (FilePath) queriesAlarmscript[queriesAlarmscript.length - 1];
                    alarmscriptFile = BFileSystem.INSTANCE.makeFile(alarmscriptFilePath);
                    File alarmscriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(alarmscriptFilePath);
                    FileWriter alarmscriptFw = new FileWriter(alarmscriptLocalFile, false);
                    alarmscriptFw.write("");
                    alarmscriptFw.close();
                    String str;
                    while ((str = alarmscriptBin.readLine()) != null) {



                        String serviceName = getName();
                        System.out.println("Reading alarmscript.js");
                        String str2 = str.replace("serviceName", serviceName).replace("alarmCountPath", alarmCountPath).replace("alarmConsoleName", alarmConsoleName);
                        System.out.println("Replacing paths");


                        try {


                            FileWriter alarmscriptFw2 = new FileWriter(alarmscriptLocalFile, true);
                            alarmscriptFw2.write(str2 + "\n");
                            alarmscriptFw2.close();
                            System.out.println("Success writing line to" + alarmscriptFileOrd.toString());


                        } catch (Exception e)
                        {
                            System.out.println("Error writing to " + alarmscriptFileOrd.toString());
                        }

                    }

                }
                //make sure to close the input stream
                finally {
                    alarmscriptIn.close();
                }


            } else {
                try {
                    //use the input stream and create a buffered reader to read
                    //each line
                    BufferedReader alarmsscriptBin = new BufferedReader(alarmscriptIn);
                    BOrd alarmscriptFileOrd = getAlarmJs();
                    BIFile alarmscriptFile = null;
                    OrdQuery[] queriesAlarmscript = alarmscriptFileOrd.parse();
                    FilePath alarmscriptFilePath = (FilePath) queriesAlarmscript[queriesAlarmscript.length - 1];
                    alarmscriptFile = BFileSystem.INSTANCE.makeFile(alarmscriptFilePath);
                    File alarmscriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(alarmscriptFilePath);
                    FileWriter alarmscriptFw = new FileWriter(alarmscriptLocalFile, false);
                    alarmscriptFw.write("");
                    alarmscriptFw.close();


                }
                //make sure to close the input stream
                finally {
                    alarmscriptIn.close();
                }
            }

        }
//handle case where file isn't found or doesn't exist.
        catch (UnresolvedException re) {
            System.out.println("Error reading " + alarmscriptFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch (IOException ioe) {
            System.out.println("Error reading " + alarmscriptFileQuery);
        }

        //use an ORD to retrieve our starting file
        BOrd notificationscriptFileQuery = BOrd.make("module://nhtml/html5/js/notifications.js");
        //use a try catch block in case the file doesn't exist
        String notificationConsoleName = getNotificationConsoleName();
        String notificationCountPath = getNotificationCount().toString();
        try {


            BIFile myNotificationscriptFile = (BIFile) notificationscriptFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader notificationscriptIn = new InputStreamReader(myNotificationscriptFile.getInputStream());
            if (getHasNotificationConsole() == true) {

                //create a try/finally block to force input stream is always closed.
                try {
                    //use the input stream and create a buffered reader to read
                    //each line
                    BufferedReader notificationscriptBin = new BufferedReader(notificationscriptIn);
                    BOrd notificationscriptFileOrd = getNotificationsJs();
                    BIFile notificationscriptFile = null;
                    OrdQuery[] queriesNotificationscript = notificationscriptFileOrd.parse();
                    FilePath notificationscriptFilePath = (FilePath) queriesNotificationscript[queriesNotificationscript.length - 1];
                    notificationscriptFile = BFileSystem.INSTANCE.makeFile(notificationscriptFilePath);
                    File notificationscriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(notificationscriptFilePath);
                    FileWriter notificationscriptFw = new FileWriter(notificationscriptLocalFile, false);
                    notificationscriptFw.write("");
                    notificationscriptFw.close();
                    String str;
                    while ((str = notificationscriptBin.readLine()) != null) {



                        String serviceName = getName();
                        System.out.println("Reading notificationcript.js");
                        String str2 = str.replace("serviceName", serviceName).replace("notificationCountPath", notificationCountPath).replace("notificationConsoleName", notificationConsoleName);
                        System.out.println("Replacing paths");


                        try {


                            FileWriter notificationscriptFw2 = new FileWriter(notificationscriptLocalFile, true);
                            notificationscriptFw2.write(str2 + "\n");
                            notificationscriptFw2.close();
                            System.out.println("Success writing line to" + notificationscriptFileOrd.toString());


                        } catch (Exception e)
                        {
                            System.out.println("Error writing to " + notificationscriptFileOrd.toString());
                        }

                    }

                }
                //make sure to close the input stream
                finally {
                    notificationscriptIn.close();
                }
            } else {
                try {
                    //use the input stream and create a buffered reader to read
                    //each line
                    BufferedReader notificationsscriptBin = new BufferedReader(notificationscriptIn);
                    BOrd notificationsscriptFileOrd = getNotificationsJs();
                    BIFile notificationsscriptFile = null;
                    OrdQuery[] queriesNotificationsscript = notificationsscriptFileOrd.parse();
                    FilePath notificationsscriptFilePath = (FilePath) queriesNotificationsscript[queriesNotificationsscript.length - 1];
                    notificationsscriptFile = BFileSystem.INSTANCE.makeFile(notificationsscriptFilePath);
                    File notificationsscriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(notificationsscriptFilePath);
                    FileWriter notificationsscriptFw = new FileWriter(notificationsscriptLocalFile, false);
                    notificationsscriptFw.write("");
                    notificationsscriptFw.close();


                }
                //make sure to close the input stream
                finally {
                    notificationscriptIn.close();
                }
            }

        }
//handle case where file isn't found or doesn't exist.
        catch (UnresolvedException re) {
            System.out.println("Error reading " + notificationscriptFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch (IOException ioe) {
            System.out.println("Error reading " + notificationscriptFileQuery);
        }

        //use an ORD to retrieve our starting file
        BOrd oatscriptFileQuery = BOrd.make("module://nhtml/html5/js/oat.js");
        //use a try catch block in case the file doesn't exist
        String oatPath = getOat().toString();
        try {


            BIFile myOatscriptFile = (BIFile) oatscriptFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader oatscriptIn = new InputStreamReader(myOatscriptFile.getInputStream());

            //create a try/finally block to force input stream is always closed.
            if (getHasOat() == true) {

                try {
                    //use the input stream and create a buffered reader to read
                    //each line
                    BufferedReader oatscriptBin = new BufferedReader(oatscriptIn);
                    BOrd oatscriptFileOrd = getOatJs();
                    BIFile oatscriptFile = null;
                    OrdQuery[] queriesOatscript = oatscriptFileOrd.parse();
                    FilePath oatscriptFilePath = (FilePath) queriesOatscript[queriesOatscript.length - 1];
                    oatscriptFile = BFileSystem.INSTANCE.makeFile(oatscriptFilePath);
                    File oatscriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(oatscriptFilePath);
                    FileWriter oatscriptFw = new FileWriter(oatscriptLocalFile, false);
                    oatscriptFw.write("");
                    oatscriptFw.close();
                    String str;
                    while ((str = oatscriptBin.readLine()) != null) {



                        String serviceName = getName();
                        System.out.println("Reading oatcript.js");
                        String str2 = str.replace("oatPath", oatPath);
                        System.out.println("Replacing paths");


                        try {


                            FileWriter oatscriptFw2 = new FileWriter(oatscriptLocalFile, true);
                            oatscriptFw2.write(str2 + "\n");
                            oatscriptFw2.close();
                            System.out.println("Success writing line to" + oatscriptFileOrd.toString());


                        } catch (Exception e)
                        {
                            System.out.println("Error writing to " + oatscriptFileOrd.toString());
                        }

                    }

                }
                //make sure to close the input stream
                finally {
                    oatscriptIn.close();
                }

            } else {
                try {
                    //use the input stream and create a buffered reader to read
                    //each line
                    BufferedReader oatscriptBin = new BufferedReader(oatscriptIn);
                    BOrd oatscriptFileOrd = getOatJs();
                    BIFile oatscriptFile = null;
                    OrdQuery[] queriesOatscript = oatscriptFileOrd.parse();
                    FilePath oatscriptFilePath = (FilePath) queriesOatscript[queriesOatscript.length - 1];
                    oatscriptFile = BFileSystem.INSTANCE.makeFile(oatscriptFilePath);
                    File oatscriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(oatscriptFilePath);
                    FileWriter oatscriptFw = new FileWriter(oatscriptLocalFile, false);
                    oatscriptFw.write("");
                    oatscriptFw.close();


                }
                //make sure to close the input stream
                finally {
                    oatscriptIn.close();
                }
            }

        }
//handle case where file isn't found or doesn't exist.
        catch (UnresolvedException re) {
            System.out.println("Error reading " + oatscriptFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch (IOException ioe) {
            System.out.println("Error reading " + oatscriptFileQuery);
        }


        //use an ORD to retrieve our starting file
        BOrd oahscriptFileQuery = BOrd.make("module://nhtml/html5/js/oah.js");
        //use a try catch block in case the file doesn't exist
        String oahPath = getOah().toString();
        try {


            BIFile myOahscriptFile = (BIFile) oahscriptFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader oahscriptIn = new InputStreamReader(myOahscriptFile.getInputStream());

            //create a try/finally block to force input stream is always closed.
            if (getHasOah() == true) {
                try {
                    //use the input stream and create a buffered reader to read
                    //each line
                    BufferedReader oahscriptBin = new BufferedReader(oahscriptIn);
                    BOrd oahscriptFileOrd = getOahJs();
                    BIFile oahscriptFile = null;
                    OrdQuery[] queriesOahscript = oahscriptFileOrd.parse();
                    FilePath oahscriptFilePath = (FilePath) queriesOahscript[queriesOahscript.length - 1];
                    oahscriptFile = BFileSystem.INSTANCE.makeFile(oahscriptFilePath);
                    File oahscriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(oahscriptFilePath);
                    FileWriter oahscriptFw = new FileWriter(oahscriptLocalFile, false);
                    oahscriptFw.write("");
                    oahscriptFw.close();
                    String str;
                    while ((str = oahscriptBin.readLine()) != null) {



                        String serviceName = getName();
                        System.out.println("Reading oahcript.js");
                        String str2 = str.replace("oahPath", oahPath);
                        System.out.println("Replacing paths");


                        try {


                            FileWriter oahscriptFw2 = new FileWriter(oahscriptLocalFile, true);
                            oahscriptFw2.write(str2 + "\n");
                            oahscriptFw2.close();
                            System.out.println("Success writing line to" + oahscriptFileOrd.toString());


                        } catch (Exception e)
                        {
                            System.out.println("Error writing to " + oahscriptFileOrd.toString());
                        }

                    }

                }
                //make sure to close the input stream
                finally {
                    oahscriptIn.close();
                }

            } else {
                try {
                    //use the input stream and create a buffered reader to read
                    //each line
                    BufferedReader oahscriptBin = new BufferedReader(oahscriptIn);
                    BOrd oahscriptFileOrd = getOahJs();
                    BIFile oahscriptFile = null;
                    OrdQuery[] queriesOahscript = oahscriptFileOrd.parse();
                    FilePath oahscriptFilePath = (FilePath) queriesOahscript[queriesOahscript.length - 1];
                    oahscriptFile = BFileSystem.INSTANCE.makeFile(oahscriptFilePath);
                    File oahscriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(oahscriptFilePath);
                    FileWriter oahscriptFw = new FileWriter(oahscriptLocalFile, false);
                    oahscriptFw.write("");
                    oahscriptFw.close();


                }
                //make sure to close the input stream
                finally {
                    oahscriptIn.close();
                }
            }
        }
//handle case where file isn't found or doesn't exist.
        catch (UnresolvedException re) {
            System.out.println("Error reading " + oahscriptFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch (IOException ioe) {
            System.out.println("Error reading " + oahscriptFileQuery);
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
        String waveSync = "";


        if (getHasEntSec() == true) {
            schedulePath = getSchedulePagePath().toString();
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
            notificationMenu = "<li id=\"Notifications\"><a id=\"NotificationConsoleLink\" target=\"hx\" href=\"" + notifConsolePath + "\"><span id=\"AllNotifications\" class=\"AllNotifications\" >Notifications</span></a></li>";
        } else {
            notificationMenu = "";
        }
        if (getHasAlarmConsole() == true) {
            alarmMenu = "<li class='last' id=\"Alarms\"><a id=\"AlarmConsoleLink\" target=\"hx\" href=\"" + alarmConsolePath + "\"><span id=\"AllAlarms\" class=\"AllAlarms\" >Alarms</span></a></li>";
        } else {
            alarmMenu = "";
        }
        if (getExternalWaveSyncLink() == true) {
            waveSync = "<li><a target=\"blank\" href='https://sync.wavevms.com'><span>Wave Sync</span></a></li>";
        } else {
            waveSync = "";
        }


        //use an ORD to retrieve our starting file
        BOrd scriptFileQuery = BOrd.make("module://nhtml/html5/js/script.js");
        //use a try catch block in case the file doesn't exist
        try {


            BIFile myScriptFile = (BIFile) scriptFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader scriptIn = new InputStreamReader(myScriptFile.getInputStream());

            //create a try/finally block to force input stream is always closed.
            try {
                //use the input stream and create a buffered reader to read
                //each line
                BufferedReader scriptBin = new BufferedReader(scriptIn);
                BOrd scriptFileOrd = getScriptJS();
                BIFile scriptFile = null;


                OrdQuery[] queriesScript = scriptFileOrd.parse();
                FilePath scriptFilePath = (FilePath) queriesScript[queriesScript.length - 1];



                scriptFile = BFileSystem.INSTANCE.makeFile(scriptFilePath);
                File scriptLocalFile = BFileSystem.INSTANCE.pathToLocalFile(scriptFilePath);
                FileWriter scriptFw = new FileWriter(scriptLocalFile, false);
                scriptFw.write("");
                scriptFw.close();
                System.out.println("Success writing line to" + scriptFileOrd.toString());
                String str;
                while ((str = scriptBin.readLine()) != null) {



                    System.out.println("Reading script.js");

                    try {
                        FileWriter scriptFw2 = new FileWriter(scriptLocalFile, true);
                        scriptFw2.write(str + "\n");
                        scriptFw2.close();
                        System.out.println("Success writing line to" + scriptFileOrd.toString());


                    } catch (Exception e)
                    {
                        System.out.println("Error writing to " + scriptFileOrd.toString());
                    }

                }

            }
            //make sure to close the input stream
            finally {
                scriptIn.close();
            }

        }
//handle case where file isn't found or doesn't exist.
        catch (UnresolvedException re) {
            System.out.println("Error reading " + scriptFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch (IOException ioe) {
            System.out.println("Error reading " + scriptFileQuery);
        }


        //use an ORD to retrieve our starting file
        BOrd usernameFileQuery = BOrd.make("module://nhtml/html5/js/username.js");
        //use a try catch block in case the file doesn't exist
        try {


            BIFile myUsernameFile = (BIFile) usernameFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader usernameIn = new InputStreamReader(myUsernameFile.getInputStream());

            //create a try/finally block to force input stream is always closed.
            try {
                //use the input stream and create a buffered reader to read
                //each line
                BufferedReader usernameBin = new BufferedReader(usernameIn);
                BOrd usernameFileOrd = getUsernameJs();
                BIFile usernameFile = null;


                OrdQuery[] queriesUsername = usernameFileOrd.parse();
                FilePath usernameFilePath = (FilePath) queriesUsername[queriesUsername.length - 1];



                usernameFile = BFileSystem.INSTANCE.makeFile(usernameFilePath);
                File usernameLocalFile = BFileSystem.INSTANCE.pathToLocalFile(usernameFilePath);
                FileWriter usernameFw = new FileWriter(usernameLocalFile, false);
                usernameFw.write("");
                usernameFw.close();
                System.out.println("Success writing line to" + usernameFileOrd.toString());
                String str;
                while ((str = usernameBin.readLine()) != null) {



                    System.out.println("Reading username.js");

                    try {
                        FileWriter usernameFw2 = new FileWriter(usernameLocalFile, true);
                        usernameFw2.write(str + "\n");
                        usernameFw2.close();
                        System.out.println("Success writing line to" + usernameFileOrd.toString());


                    } catch (Exception e)
                    {
                        System.out.println("Error writing to " + usernameFileOrd.toString());
                    }

                }

            }
            //make sure to close the input stream
            finally {
                usernameIn.close();
            }

        }
//handle case where file isn't found or doesn't exist.
        catch (UnresolvedException re) {
            System.out.println("Error reading " + usernameFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch (IOException ioe) {
            System.out.println("Error reading " + usernameFileQuery);
        }


        //use an ORD to retrieve our starting file
        BOrd cssFileQuery = BOrd.make("module://nhtml/html5/css/style.css");
        //use a try catch block in case the file doesn't exist
        try {


            BIFile myCssFile = (BIFile) cssFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader cssIn = new InputStreamReader(myCssFile.getInputStream());

            //create a try/finally block to force input stream is always closed.
            try {
                //use the input stream and create a buffered reader to read
                //each line
                BufferedReader cssBin = new BufferedReader(cssIn);
                BOrd cssFileOrd = getStyleCSS();
                BIFile cssFile = null;

                OrdQuery[] queriesCss = cssFileOrd.parse();
                FilePath cssFilePath = (FilePath) queriesCss[queriesCss.length - 1];



                cssFile = BFileSystem.INSTANCE.makeFile(cssFilePath);
                File cssLocalFile = BFileSystem.INSTANCE.pathToLocalFile(cssFilePath);
                FileWriter cssFw = new FileWriter(cssLocalFile, false);
                cssFw.write("");
                cssFw.close();
                System.out.println("Success clearing " + cssFileOrd.toString());

                System.out.println("Success writing line to" + cssFileOrd.toString());

                String str;
                while ((str = cssBin.readLine()) != null) {



                    System.out.println("Reading CSS");

                    try {
                        FileWriter cssFw2 = new FileWriter(cssLocalFile, true);
                        cssFw2.write(str + "\n");
                        cssFw2.close();
                        System.out.println("Success writing line to" + cssFileOrd.toString());


                    } catch (Exception e)
                    {
                        System.out.println("Error writing to " + cssFileOrd.toString());
                    }

                }

            }
            //make sure to close the input stream
            finally {
                cssIn.close();
            }

        }
//handle case where file isn't found or doesn't exist.
        catch (UnresolvedException re) {
            System.out.println("Error reading " + cssFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch (IOException ioe) {
            System.out.println("Error reading " + cssFileQuery);
        }


        //use an ORD to retrieve our starting file
        BOrd htmlFileQuery = BOrd.make("module://nhtml/html5/html/index.html");
        //use a try catch block in case the file doesn't exist
        try {


            BIFile myHtmlFile = (BIFile) htmlFileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader htmlIn = new InputStreamReader(myHtmlFile.getInputStream());

            //create a try/finally block to force input stream is always closed.
            try {
                //use the input stream and create a buffered reader to read
                //each line
                BufferedReader htmlBin = new BufferedReader(htmlIn);
                BOrd htmlFileOrd = getIndexHTML();
                BIFile htmlFile = null;


                OrdQuery[] queriesHtml = htmlFileOrd.parse();
                FilePath htmlFilePath = (FilePath) queriesHtml[queriesHtml.length - 1];



                htmlFile = BFileSystem.INSTANCE.makeFile(htmlFilePath);
                File localHtmlFile = BFileSystem.INSTANCE.pathToLocalFile(htmlFilePath);
                FileWriter fw = new FileWriter(localHtmlFile, false);
                fw.write("");
                fw.close();
                System.out.println("Success writing line to " + htmlFileOrd.toString());
                String str;
                while ((str = htmlBin.readLine()) != null) {



                    System.out.println("Reading HTML");

                    String str2 = str.replace("homePagePath", homePagePath).replace("logoPath", logoPath).replace("historiesMenu", historiesMenu).replace("schedulesMenu", schedulesMenu).replace("reportMenu", reportMenu).replace("docMenu", docMenu).replace("waveSync", waveSync).replace("notificationMenu", notificationMenu).replace("alarmMenu", alarmMenu).replace("entSecMenu", entSecMenu);
                    System.out.println("Replacing Paths");
                    try {
                        FileWriter htmlFw2 = new FileWriter(localHtmlFile, true);
                        htmlFw2.write(str2 + "\n");
                        htmlFw2.close();
                        System.out.println("Success writing line to " + htmlFileOrd.toString());


                    } catch (Exception e)
                    {
                        System.out.println("Error writing to " + htmlFileOrd.toString());
                    }

                }

            }
            //make sure to close the input stream
            finally {
                htmlIn.close();
            }

        }
//handle case where file isn't found or doesn't exist.
        catch (UnresolvedException re) {
            System.out.println("Error reading " + htmlFileQuery);

        }
//handle IO exceptions from trying to read from file
        catch (IOException ioe) {
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









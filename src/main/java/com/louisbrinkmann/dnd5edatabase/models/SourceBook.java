package com.louisbrinkmann.dnd5edatabase.models;

import lombok.Getter;

@Getter
public enum SourceBook {
    PLAYERS_HANDBOOK("Player's Handbook", 2014),
    MONSTER_MANUAL("Monster Manual", 2014),
    DUNGEON_MASTERS_GUIDE("Dungeon Master's Guide", 2014),
    HOARD_OF_THE_DRAGON_QUEEN("Hoard of the Dragon Queen", 2014),
    THE_RISE_OF_TIAMAT("The Rise of Tiamat", 2014),
    PRINCES_OF_THE_APOCALYPSE("Princes of the Apocalypse", 2015),
    OUT_OF_THE_ABYSS("Out of the Abyss", 2015),
    SWORD_COAST_ADVENTURERS_GUIDE("Sword Coast Adventurer's Guide", 2015),
    CURSE_OF_STRAHD("Curse of Strahd", 2016),
    STORM_KINGS_THUNDER("Storm King's Thunder", 2016),
    TALES_FROM_THE_YAWNING_PORTAL("Tales from the Yawning Portal", 2017),
    VOLOS_GUIDE_TO_MONSTERS("Volo's Guide to Monsters", 2016),
    XANATHARS_GUIDE_TO_EVERYTHING("Xanathar's Guide to Everything", 2017),
    TOMB_OF_ANNIHILATION("Tomb of Annihilation", 2017),
    MORDENKAINENS_TOME_OF_FOES("Mordenkainen's Tome of Foes", 2018),
    WATERDEEP_DRAGON_HEIST("Waterdeep: Dragon Heist", 2018),
    WATERDEEP_DUNGEON_OF_THE_MAD_MAGE("Waterdeep: Dungeon of the Mad Mage", 2018),
    GUILDMASTERS_GUIDE_TO_RAVNICA("Guildmaster's Guide to Ravnica", 2018),
    ACQUISITIONS_INCORPORATED("Acquisitions Incorporated", 2019),
    GHOSTS_OF_SALT_MARSH("Ghosts of Saltmarsh", 2019),
    BALDURS_GATE_DESCENT_INTO_AVERNUS("Baldur's Gate: Descent into Avernus", 2019),
    EBERRON_RISING_FROM_THE_LAST_WAR("Eberron: Rising from the Last War", 2019),
    EXPLORERS_GUIDE_TO_WILDEMOUNT("Explorer's Guide to Wildemount", 2020),
    MYTHIC_ODYSSEYS_OF_THEROS("Mythic Odysseys of Theros", 2020),
    ICEWIND_DALE_RIME_OF_THE_FROSTMAIDEN("Icewind Dale: Rime of the Frostmaiden", 2020),
    TASHAS_CAULDRON_OF_EVERYTHING("Tasha's Cauldron of Everything", 2020),
    VAN_RICHTENS_GUIDE_TO_RAVENLOFT("Van Richten's Guide to Ravenloft", 2021),
    THE_WILD_BEYOND_THE_WITCHLIGHT("The Wild Beyond the Witchlight", 2021),
    STRIXHAVEN_CURRICULUM_OF_CHAOS("Strixhaven: Curriculum of Chaos", 2021),
    MORDENKAINEN_PRESENTS_MONSTERS_OF_THE_MULTIVERSE("Mordenkainen Presents: Monsters of the Multiverse", 2022),
    CRITICAL_ROLE_CALL_OF_THE_NETHERDEEP("Critical Role: Call of the Netherdeep", 2022),
    JOURNEY_THROUGH_THE_RADIANT_CITADEL("Journey Through the Radiant Citadel", 2022),
    DRAGONS_OF_STORMWRECK_ISLE("Dragons of Stormwreck Isle", 2022),
    DRAGONLANCE_SHADOW_OF_THE_DRAGON_QUEEN("Dragonlance: Shadow of the Dragon Queen", 2022),
    KEYS_FROM_THE_GOLDEN_VAULT("Keys from the Golden Vault", 2023),
    BIGBY_PRESENTS_GLORY_OF_THE_GIANTS("Bigby Presents: Glory of the Giants", 2023),
    THE_BOOK_OF_MANY_THINGS("The Book of Many Things", 2023),
    PLANESCAPE_ADVENTURES_IN_THE_MULTIVERSE("Planescape: Adventures in the Multiverse", 2023);

    private final String title;
    private final int year;

    SourceBook(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }
}

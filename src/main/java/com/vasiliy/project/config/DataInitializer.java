package com.vasiliy.project.config;

import com.vasiliy.project.entity.info.AccountingType;
import com.vasiliy.project.entity.info.Category;
import com.vasiliy.project.entity.info.Form;
import com.vasiliy.project.repository.AccountingTypeRepository;
import com.vasiliy.project.repository.CategoryRepository;
import com.vasiliy.project.repository.FormRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final FormRepository formRepository;
    private final AccountingTypeRepository accountingTypeRepository;


    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.findAll().isEmpty()) {
            List<Category> categories = new ArrayList<>();

            categories.add(new Category("0010", "Вегетотропные средства"));
            categories.add(new Category("0010-0010", "Адренолитические средства"));
            categories.add(new Category("0010-0010-0010", "Альфа- и бета-адреноблокаторы"));
            categories.add(new Category("0010-0010-0020", "Альфа-адреноблокаторы"));
            categories.add(new Category("0010-0010-0020-0010", "Альфа-адреноблокаторы в комбинациях"));
            categories.add(new Category("0010-0010-0030", "Бета-адреноблокаторы"));
            categories.add(new Category("0010-0010-0030-0010", "Бета-адреноблокаторы в комбинациях"));
            categories.add(new Category("0010-0010-0040", "Симпатолитики"));
            categories.add(new Category("0010-0010-0040-0010", "Симпатолитики в комбинациях"));
            categories.add(new Category("0010-0020", "Адреномиметические средства"));
            categories.add(new Category("0010-0020-0010", "Адрено- и симпатомиметики (альфа-, бета-)"));
            categories.add(new Category("0010-0020-0010-0010", "Адрено- и симпатомиметики (альфа-, бета-) в комбинациях"));
            categories.add(new Category("0010-0020-0020", "Альфа-адреномиметики"));
            categories.add(new Category("0010-0020-0020-0010", "Альфа-адреномиметики в комбинациях"));
            categories.add(new Category("0010-0020-0030", "Бета-адреномиметики"));
            categories.add(new Category("0010-0020-0030-0010", "Бета-адреномиметики в комбинациях"));
            categories.add(new Category("0010-0030", "Холинолитические средства"));
            categories.add(new Category("0010-0030-0010", "м-, н-Холинолитики"));
            categories.add(new Category("0010-0030-0010-0010", "м-Холинолитики"));
            categories.add(new Category("0010-0030-0010-0010-0010", "м-Холинолитики в комбинациях"));
            categories.add(new Category("0010-0030-0020", "н-Холинолитики (ганглиоблокаторы)"));
            categories.add(new Category("0010-0030-0030", "н-Холинолитики (миорелаксанты)"));
            categories.add(new Category("0010-0030-0030-0010", "н-Холинолитики (миорелаксанты) в комбинациях"));
            categories.add(new Category("0010-0040", "Холиномиметические средства"));
            categories.add(new Category("0010-0040-0010", "м-, н-Холиномиметики, в т.ч. антихолинэстеразные средства"));
            categories.add(new Category("0010-0040-0020", "м-Холиномиметики"));
            categories.add(new Category("0010-0040-0020-0010", "м-Холиномиметики в комбинациях"));
            categories.add(new Category("0010-0040-0030", "н-Холиномиметики"));

            categories.add(new Category("0020", "Гематотропные средства"));
            categories.add(new Category("0020-0010", "Антиагреганты"));
            categories.add(new Category("0020-0010-0010", "Антиагреганты в комбинациях"));
            categories.add(new Category("0020-0020", "Антикоагулянты"));
            categories.add(new Category("0020-0020-0010", "Антикоагулянты в комбинациях"));
            categories.add(new Category("0020-0080", "Другие гематотропные средства"));
            categories.add(new Category("0020-0030", "Заменители плазмы и других компонентов крови"));
            categories.add(new Category("0020-0030-0010", "Заменители плазмы и других компонентов крови в комбинациях"));
            categories.add(new Category("0020-0040", "Ингибиторы фибринолиза"));
            categories.add(new Category("0020-0050", "Коагулянты (в т.ч. факторы свертывания крови), гемостатики"));
            categories.add(new Category("0020-0050-0010", "Коагулянты (в т.ч. факторы свертывания крови), гемостатики в комбинациях"));
            categories.add(new Category("0020-0060", "Стимуляторы гемопоэза"));
            categories.add(new Category("0020-0060-0010", "Стимуляторы гемопоэза в комбинациях"));
            categories.add(new Category("0020-0070", "Фибринолитики"));

            categories.add(new Category("0030", "Гомеопатические средства"));

            categories.add(new Category("0040", "Гормоны и их антагонисты"));
            categories.add(new Category("0040-0010", "Андрогены, антиандрогены"));
            categories.add(new Category("0040-0010-0010", "Андрогены, антиандрогены в комбинациях"));
            categories.add(new Category("0040-0020", "Глюкагон и его аналоги"));
            categories.add(new Category("0040-0030", "Гормоны гипоталамуса, гипофиза, гонадотропины и их антагонисты"));
            categories.add(new Category("0040-0030-0010", "Гормоны гипоталамуса, гипофиза, гонадотропины и их антагонисты в комбинациях"));
            categories.add(new Category("0040-0040", "Гормоны щитовидной и паращитовидных желез, их аналоги и антагонисты (включая антитиреоидные средства)"));
            categories.add(new Category("0040-0040-0010", "Гормоны щитовидной и паращитовидных желез, их аналоги и антагонисты в комбинациях"));
            categories.add(new Category("0040-0080", "Другие гормоны, их аналоги и антагонисты"));
            categories.add(new Category("0040-0050", "Инсулины"));
            categories.add(new Category("0040-0050-0010", "Инсулины в комбинациях"));
            categories.add(new Category("0040-0060", "Кортикостероиды"));
            categories.add(new Category("0040-0060-0010", "Глюкокортикостероиды"));
            categories.add(new Category("0040-0060-0010-0010", "Глюкокортикостероиды в комбинациях"));
            categories.add(new Category("0040-0060-0020", "Минералокортикоиды"));
            categories.add(new Category("0040-0070", "Эстрогены, гестагены; их гомологи и антагонисты"));
            categories.add(new Category("0040-0070-0010", "Эстрогены, гестагены; их гомологи и антагонисты в комбинациях"));

            categories.add(new Category("0050", "Диагностические средства"));
            categories.add(new Category("0050-0030", "Другие диагностические средства"));
            categories.add(new Category("0050-0010", "Иммунобиологические диагностические средства"));
            categories.add(new Category("0050-0020", "Контрастные средства"));
            categories.add(new Category("0050-0020-0020", "Магнитно-резонансные контрастные средства"));
            categories.add(new Category("0050-0020-0010", "Рентгеноконтрастные средства"));
            categories.add(new Category("0050-0020-0030", "Ультразвуковые контрастные средства"));

            categories.add(new Category("0060", "Иммунотропные средства"));
            categories.add(new Category("0060-0010", "Вакцины, сыворотки, фаги и анатоксины"));
            categories.add(new Category("0060-0010-0010", "Вакцины, сыворотки, фаги и анатоксины в комбинациях"));
            categories.add(new Category("0060-0150", "Иммуноглобулины"));
            categories.add(new Category("0060-0150-0150", "Иммуноглобулины в комбинациях"));
            categories.add(new Category("0060-0030", "Иммунодепрессанты"));
            categories.add(new Category("0060-0040", "Иммуномодуляторы"));
            categories.add(new Category("0060-0040-0040", "Другие иммуномодуляторы"));
            categories.add(new Category("0060-0040-0040-0010", "Другие иммуномодуляторы в комбинациях"));
            categories.add(new Category("0060-0040-0030", "Индукторы интерферонов"));
            categories.add(new Category("0060-0040-0010", "Интерлейкины"));
            categories.add(new Category("0060-0040-0020", "Интерфероны"));
            categories.add(new Category("0060-0040-0020-0010", "Интерфероны в комбинациях"));

            categories.add(new Category("0070", "Интермедианты"));
            categories.add(new Category("0070-0005", "Агонисты I1-имидазолиновых рецепторов"));
            categories.add(new Category("0070-0010", "Аденозинергические средства"));
            categories.add(new Category("0070-0010-0010", "Аденозинергические средства в комбинациях"));
            categories.add(new Category("0070-0020", "Антагонисты рецепторов ангиотензина II (AT1-подтип)"));
            categories.add(new Category("0070-0020-0010", "Антагонисты рецепторов ангиотензина II (AT1-подтип) в комбинациях"));
            categories.add(new Category("0070-0030", "Гистаминергические средства"));
            categories.add(new Category("0070-0030-0010", "Гистаминолитики"));
            categories.add(new Category("0070-0030-0010-0030", "Стабилизаторы мембран тучных клеток"));
            categories.add(new Category("0070-0030-0020", "Гистаминомиметики"));
            categories.add(new Category("0070-0040", "Дофаминомиметики"));
            categories.add(new Category("0070-0040-0010", "Дофаминомиметики в комбинациях"));
            categories.add(new Category("0070-0070", "Другие интермедианты"));
            categories.add(new Category("0070-0026", "Ингибиторы ФДЭ-5"));
            categories.add(new Category("0070-0050", "Простагландины, тромбоксаны, лейкотриены, их аналоги и антагонисты"));
            categories.add(new Category("0070-0050-0010", "Простагландины, тромбоксаны, лейкотриены их аналоги и антагонисты в комбинациях"));
            categories.add(new Category("0070-0060", "Серотонинергические средства"));
            categories.add(new Category("0070-0060-0010", "Серотонинергические средства в комбинациях"));

            categories.add(new Category("0080", "Метаболики"));
            categories.add(new Category("0080-0010", "Анаболики"));
            categories.add(new Category("0080-0010-0010", "Анаболики в комбинациях"));
            categories.add(new Category("0080-0020", "Антигипоксанты и антиоксиданты"));
            categories.add(new Category("0080-0020-0010", "Антигипоксанты и антиоксиданты в комбинациях"));
            categories.add(new Category("0080-0030", "Белки и аминокислоты"));
            categories.add(new Category("0080-0030-0010", "Белки и аминокислоты в комбинациях"));
            categories.add(new Category("0080-0040", "Витамины и витаминоподобные средства"));
            categories.add(new Category("0080-0040-0030", "Витамины водорастворимые"));
            categories.add(new Category("0080-0040-0030-0010", "Витамины группы B"));
            categories.add(new Category("0080-0040-0010", "Витамины и витаминоподобные средства в комбинациях"));
            categories.add(new Category("0080-0050", "Гипергликемические средства"));
            categories.add(new Category("0080-0060", "Гипогликемические синтетические и другие средства"));
            categories.add(new Category("0080-0060-0010", "Гипогликемические синтетические и другие средства в комбинациях"));
            categories.add(new Category("0080-0070", "Гиполипидемические средства"));
            categories.add(new Category("0080-0070-0055", "Гиполипидемические средства в комбинациях"));
            categories.add(new Category("0080-0070-0060", "Другие гиполипидемические средства"));
            categories.add(new Category("0080-0070-0060-0010", "Другие гиполипидемические средства в комбинациях"));
            categories.add(new Category("0080-0070-0020", "Никотинаты"));
            categories.add(new Category("0080-0070-0030", "Секвестранты желчных кислот"));
            categories.add(new Category("0080-0070-0040", "Статины"));
            categories.add(new Category("0080-0070-0050", "Фибраты"));
            categories.add(new Category("0080-0080", "Детоксицирующие средства, включая антидоты"));
            categories.add(new Category("0080-0080-0010", "Детоксицирующие средства, включая антидоты, в комбинациях"));
            categories.add(new Category("0080-0160", "Другие метаболики"));
            categories.add(new Category("0080-0160-0010", "Другие метаболики в комбинациях"));
            categories.add(new Category("0080-0155", "Ингибиторы энкефалиназы"));
            categories.add(new Category("0080-0090", "Корректоры метаболизма костной и хрящевой ткани"));
            categories.add(new Category("0080-0090-0010", "Корректоры метаболизма костной и хрящевой ткани в комбинациях"));
            categories.add(new Category("0080-0100", "Макро- и микроэлементы"));
            categories.add(new Category("0080-0100-0010", "Макро- и микроэлементы в комбинациях"));
            categories.add(new Category("0080-0110", "Регидратанты"));
            categories.add(new Category("0080-0110-0010", "Регидратанты в комбинациях"));
            categories.add(new Category("0080-0120", "Регуляторы водно-электролитного баланса и КЩС"));
            categories.add(new Category("0080-0120-0010", "Регуляторы водно-электролитного баланса и КЩС в комбинациях"));
            categories.add(new Category("0080-0135", "Средства для энтерального и парентерального питания"));
            categories.add(new Category("0080-0135-0010", "Средства для энтерального и парентерального питания в комбинациях"));
            categories.add(new Category("0080-0130", "Средства, влияющие на обмен мочевой кислоты"));
            categories.add(new Category("0080-0140", "Средства, препятствующие образованию и способствующие растворению конкрементов"));
            categories.add(new Category("0080-0140-0010", "Средства, препятствующие образованию и способствующие растворению конкрементов в комбинациях"));
            categories.add(new Category("0080-0150", "Ферменты и антиферменты"));
            categories.add(new Category("0080-0150-0010", "Ферменты и антиферменты в комбинациях"));

            categories.add(new Category("0090", "Нейротропные средства"));
            categories.add(new Category("0090-0010", "Анксиолитики"));
            categories.add(new Category("0090-0020", "Антидепрессанты"));
            categories.add(new Category("0090-0020-0010", "Антидепрессанты в комбинациях"));
            categories.add(new Category("0090-0130", "Другие нейротропные средства"));
            categories.add(new Category("0090-0130-0010", "Другие нейротропные средства в комбинации"));
            categories.add(new Category("0090-0030", "Местнораздражающие средства"));
            categories.add(new Category("0090-0030-0010", "Местнораздражающие средства в комбинациях"));
            categories.add(new Category("0090-0040", "Местные анестетики"));
            categories.add(new Category("0090-0040-0010", "Местные анестетики в комбинациях"));
            categories.add(new Category("0090-0050", "Наркозные средства"));
            categories.add(new Category("0090-0060", "Нейролептики"));
            categories.add(new Category("0090-0063", "Ноотропы"));
            categories.add(new Category("0090-0063-0010", "Ноотропы в комбинациях"));
            categories.add(new Category("0090-0065", "Нормотимики"));
            categories.add(new Category("0090-0070", "Общетонизирующие средства и адаптогены"));
            categories.add(new Category("0090-0070-0010", "Общетонизирующие средства и адаптогены в комбинациях"));
            categories.add(new Category("0090-0080", "Опиоиды, их аналоги и антагонисты"));
            categories.add(new Category("0090-0080-0030", "Опиоидные наркотические анальгетики"));
            categories.add(new Category("0090-0080-0030-0050", "Опиоидные наркотические анальгетики в комбинациях"));
            categories.add(new Category("0090-0080-0010", "Опиоидные ненаркотические анальгетики"));
            categories.add(new Category("0090-0080-0010-0010", "Опиоидные ненаркотические анальгетики в комбинациях"));
            categories.add(new Category("0090-0090", "Противопаркинсонические средства"));
            categories.add(new Category("0090-0090-0010", "Противопаркинсонические средства в комбинациях"));
            categories.add(new Category("0090-0100", "Противоэпилептические средства"));
            categories.add(new Category("0090-0100-0010", "Противоэпилептические средства в комбинациях"));
            categories.add(new Category("0090-0105", "Психостимуляторы"));
            categories.add(new Category("0090-0105-0010", "Психостимуляторы в комбинациях"));
            categories.add(new Category("0090-0115", "Седативные средства"));
            categories.add(new Category("0090-0115-0010", "Седативные средства в комбинациях"));
            categories.add(new Category("0090-0117", "Снотворные средства"));
            categories.add(new Category("0090-0117-0010", "Снотворные средства в комбинациях"));
            categories.add(new Category("0090-0120", "Средства, влияющие на нервно-мышечную передачу"));

            categories.add(new Category("0100", "Ненаркотические анальгетики, включая нестероидные и другие противовоспалительные средства"));
            categories.add(new Category("0100-0090", "Анилиды"));
            categories.add(new Category("0100-0090-0010", "Анилиды в комбинациях"));
            categories.add(new Category("0100-0030", "НПВС — Бутилпиразолидины"));
            categories.add(new Category("0100-0030-0010", "НПВС — Бутилпиразолидины в комбинациях"));
            categories.add(new Category("0100-0080", "НПВС — Коксибы"));
            categories.add(new Category("0100-0050", "НПВС — Оксикамы"));
            categories.add(new Category("0100-0050-0010", "НПВС — Оксикамы в комбинациях"));
            categories.add(new Category("0100-0020", "НПВС — Пиразолоны"));
            categories.add(new Category("0100-0020-0010", "НПВС — Пиразолоны в комбинациях"));
            categories.add(new Category("0100-0060", "НПВС — Производные пропионовой кислоты"));
            categories.add(new Category("0100-0060-0010", "НПВС — Производные пропионовой кислоты в комбинациях"));
            categories.add(new Category("0100-0010", "НПВС — Производные салициловой кислоты"));
            categories.add(new Category("0100-0010-0010", "НПВС — Производные салициловой кислоты в комбинациях"));
            categories.add(new Category("0100-0040", "НПВС — Производные уксусной кислоты и родственные соединения"));
            categories.add(new Category("0100-0040-0010", "НПВС — Производные уксусной кислоты и родственные соединения в комбинациях"));
            categories.add(new Category("0100-0070", "НПВС — Фенаматы"));
            categories.add(new Category("0100-0200", "Прочие ненаркотические анальгетики, включая нестероидные и другие противовоспалительные средства"));
            categories.add(new Category("0100-0200-0010", "Прочие ненаркотические анальгетики, включая нестероидные и другие противовоспалительные средства, в комбинациях"));

            categories.add(new Category("0110", "Органотропные средства"));
            categories.add(new Category("0110-0010", "Дерматотропные средства"));
            categories.add(new Category("0110-0010-0010", "Дерматотропные средства в комбинациях"));
            categories.add(new Category("0110-0070", "Другие органотропные средства"));
            categories.add(new Category("0110-0020", "Желудочно-кишечные средства"));
            categories.add(new Category("0110-0020-0010", "Адсорбенты"));
            categories.add(new Category("0110-0020-0010-0010", "Адсорбенты в комбинациях"));
            categories.add(new Category("0110-0020-0020", "Антациды"));
            categories.add(new Category("0110-0020-0020-0010", "Антациды в комбинациях"));
            categories.add(new Category("0110-0020-0030", "Ветрогонные средства"));
            categories.add(new Category("0110-0020-0030-0010", "Ветрогонные средства в комбинациях"));
            categories.add(new Category("0110-0020-0035", "Гастропротекторы"));
            categories.add(new Category("0110-0020-0040", "Гепатопротекторы"));
            categories.add(new Category("0110-0020-0040-0010", "Гепатопротекторы в комбинациях"));
            categories.add(new Category("0110-0020-0140", "Другие желудочно-кишечные средства"));
            categories.add(new Category("0110-0020-0140-0010", "Другие желудочно-кишечные средства в комбинациях"));
            categories.add(new Category("0110-0020-0050", "Желчегонные средства и препараты желчи"));
            categories.add(new Category("0110-0020-0050-0010", "Желчегонные средства и препараты желчи в комбинациях"));
            categories.add(new Category("0110-0020-0070", "Ингибиторы протонного насоса"));
            categories.add(new Category("0110-0020-0070-0010", "Ингибиторы протонного насоса в комбинациях"));
            categories.add(new Category("0110-0020-0085", "Прокинетики"));
            categories.add(new Category("0110-0020-0075", "Противодиарейные средства"));
            categories.add(new Category("0110-0020-0075-0010", "Противодиарейные средства в комбинациях"));
            categories.add(new Category("0110-0020-0080", "Противорвотные средства"));
            categories.add(new Category("0110-0020-0080-0010", "Противорвотные средства в комбинациях"));
            categories.add(new Category("0110-0020-0090", "Регуляторы аппетита"));
            categories.add(new Category("0110-0020-0090-0010", "Регуляторы аппетита в комбинациях"));
            categories.add(new Category("0110-0020-0100", "Слабительные средства"));
            categories.add(new Category("0110-0020-0100-0010", "Слабительные средства в комбинациях"));
            categories.add(new Category("0110-0020-0110", "Средства, нормализующие микрофлору кишечника"));
            categories.add(new Category("0110-0020-0110-0010", "Средства, нормализующие микрофлору кишечника, в комбинациях"));
            categories.add(new Category("0110-0020-0120", "Стимуляторы моторики ЖКТ, в том числе рвотные средства"));
            categories.add(new Category("0110-0020-0130", "Стоматологические средства"));
            categories.add(new Category("0110-0020-0130-0010", "Стоматологические средства в комбинациях"));
            categories.add(new Category("0110-0025", "Офтальмологические средства"));
            categories.add(new Category("0110-0025-0010", "Офтальмологические средства в комбинациях"));
            categories.add(new Category("0110-0030", "Респираторные средства"));
            categories.add(new Category("0110-0030-0010", "Антиконгестанты"));
            categories.add(new Category("0110-0030-0010-0010", "Антиконгестанты в комбинациях"));
            categories.add(new Category("0110-0030-0060", "Другие респираторные средства"));
            categories.add(new Category("0110-0030-0060-0010", "Другие респираторные средства в комбинациях"));
            categories.add(new Category("0110-0030-0020", "Противокашлевые средства"));
            categories.add(new Category("0110-0030-0020-0010", "Противокашлевые средства в комбинациях"));
            categories.add(new Category("0110-0030-0030", "Секретолитики и стимуляторы моторной функции дыхательных путей"));
            categories.add(new Category("0110-0030-0030-0010", "Секретолитики и стимуляторы моторной функции дыхательных путей в комбинациях"));
            categories.add(new Category("0110-0030-0040", "Стимуляторы дыхания"));
            categories.add(new Category("0110-0030-0040-0010", "Стимуляторы дыхания в комбинациях"));
            categories.add(new Category("0110-0030-0050", "Сурфактанты"));
            categories.add(new Category("0110-0040", "Сердечно-сосудистые средства"));
            categories.add(new Category("0110-0040-0010", "Ангиопротекторы и корректоры микроциркуляции"));
            categories.add(new Category("0110-0040-0010-0010", "Ангиопротекторы и корректоры микроциркуляции в комбинациях"));
            categories.add(new Category("0110-0040-0015", "Антагонисты рецепторов ангиотензина II (AT1-подтип)"));
            categories.add(new Category("0110-0040-0015-0010", "Антагонисты рецепторов ангиотензина II (AT1-подтип) в комбинациях"));
            categories.add(new Category("0110-0040-0016", "Антагонисты рецепторов брадикинина"));
            categories.add(new Category("0110-0040-0020", "Антиаритмические средства"));
            categories.add(new Category("0110-0040-0020-0010", "Антиаритмические средства в комбинациях"));
            categories.add(new Category("0110-0040-0030", "Блокаторы кальциевых каналов"));
            categories.add(new Category("0110-0040-0030-0010", "Блокаторы кальциевых каналов в комбинациях"));
            categories.add(new Category("0110-0040-0040", "Вазодилататоры"));
            categories.add(new Category("0110-0040-0040-0010", "Вазодилататоры в комбинациях"));
            categories.add(new Category("0110-0040-0050", "Гипертензивные средства"));
            categories.add(new Category("0110-0040-0100", "Другие сердечно-сосудистые средства"));
            categories.add(new Category("0110-0040-0100-0010", "Другие сердечно-сосудистые средства в комбинациях"));
            categories.add(new Category("0110-0040-0060", "Ингибиторы АПФ"));
            categories.add(new Category("0110-0040-0060-0010", "Ингибиторы АПФ в комбинациях"));
            categories.add(new Category("0110-0040-0065", "Ингибиторы ренина"));
            categories.add(new Category("0110-0040-0065-0010", "Ингибиторы ренина в комбинациях"));
            categories.add(new Category("0110-0040-0070", "Корректоры нарушений мозгового кровообращения"));
            categories.add(new Category("0110-0040-0070-0010", "Корректоры нарушений мозгового кровообращения в комбинациях"));
            categories.add(new Category("0110-0040-0080", "Нитраты и нитратоподобные средства"));
            categories.add(new Category("0110-0040-0080-0010", "Нитраты и нитратоподобные средства в комбинациях"));
            categories.add(new Category("0110-0040-0090", "Сердечные гликозиды и негликозидные кардиотонические средства"));
            categories.add(new Category("0110-0040-0090-0010", "Сердечные гликозиды и негликозидные кардиотонические средства в комбинациях"));
            categories.add(new Category("0110-0050", "Спазмолитики миотропные"));
            categories.add(new Category("0110-0050-0010", "Спазмолитики миотропные в комбинациях"));
            categories.add(new Category("0110-0060", "Средства, регулирующие функцию органов мочеполовой системы и репродукцию"));
            categories.add(new Category("0110-0060-0010", "Диуретики"));
            categories.add(new Category("0110-0060-0010-0010", "Диуретики в комбинациях"));
            categories.add(new Category("0110-0060-0070", "Другие средства, регулирующие функцию органов мочеполовой системы и репродукцию"));
            categories.add(new Category("0110-0060-0020", "Контрацептивы негормональные"));
            categories.add(new Category("0110-0060-0030", "Регуляторы потенции"));
            categories.add(new Category("0110-0060-0040", "Средства, влияющие на обмен веществ в предстательной железе, и корректоры уродинамики"));
            categories.add(new Category("0110-0060-0040-0010", "Средства, влияющие на обмен веществ в предстательной железе, и корректоры уродинамики в комбинациях"));
            categories.add(new Category("0110-0060-0050", "Токолитики"));
            categories.add(new Category("0110-0060-0060", "Утеротоники"));

            categories.add(new Category("0120", "Противомикробные, противопаразитарные и противоглистные средства"));
            categories.add(new Category("0120-0010", "Антибиотики"));
            categories.add(new Category("0120-0010-0010", "Аминогликозиды"));
            categories.add(new Category("0120-0010-0010-0010", "Аминогликозиды в комбинациях"));
            categories.add(new Category("0120-0010-0020", "Амфениколы"));
            categories.add(new Category("0120-0010-0020-0010", "Амфениколы в комбинациях"));
            categories.add(new Category("0120-0010-0030", "Ансамицины"));
            categories.add(new Category("0120-0010-0040", "Гликопептиды"));
            categories.add(new Category("0120-0010-0120", "Другие антибиотики"));
            categories.add(new Category("0120-0010-0120-0010", "Другие антибиотики в комбинациях"));
            categories.add(new Category("0120-0010-0050", "Карбапенемы"));
            categories.add(new Category("0120-0010-0050-0010", "Карбапенемы в комбинациях"));
            categories.add(new Category("0120-0010-0060", "Линкозамиды"));
            categories.add(new Category("0120-0010-0060-0010", "Линкозамиды в комбинациях"));
            categories.add(new Category("0120-0010-0070", "Макролиды и азалиды"));
            categories.add(new Category("0120-0010-0070-0010", "Макролиды и азалиды в комбинациях"));
            categories.add(new Category("0120-0010-0080", "Монобактамы"));
            categories.add(new Category("0120-0010-0085", "Оксазолидиноны"));
            categories.add(new Category("0120-0010-0090", "Пенициллины"));
            categories.add(new Category("0120-0010-0090-0010", "Пенициллины в комбинациях"));
            categories.add(new Category("0120-0010-0100", "Тетрациклины"));
            categories.add(new Category("0120-0010-0100-0010", "Тетрациклины в комбинациях"));
            categories.add(new Category("0120-0010-0110", "Цефалоспорины"));
            categories.add(new Category("0120-0010-0110-0010", "Цефалоспорины в комбинациях"));
            categories.add(new Category("0120-0020", "Антисептики и дезинфицирующие средства"));
            categories.add(new Category("0120-0020-0010", "Антисептики и дезинфицирующие средства в комбинациях"));
            categories.add(new Category("0120-0090", "Другие противомикробные, противопаразитарные и противоглистные средства"));
            categories.add(new Category("0120-0090-0010", "Другие противомикробные, противопаразитарные и противоглистные средства в комбинациях"));
            categories.add(new Category("0120-0030", "Противовирусные средства"));
            categories.add(new Category("0120-0030-0005", "Противовирусные (за исключением ВИЧ) средства"));
            categories.add(new Category("0120-0030-0005-0010", "Противовирусные (за исключением ВИЧ) средства в комбинациях"));
            categories.add(new Category("0120-0030-0010", "Средства для лечения ВИЧ-инфекции"));
            categories.add(new Category("0120-0030-0010-0010", "Средства для лечения ВИЧ-инфекции в комбинациях"));
            categories.add(new Category("0120-0040", "Противоглистные средства"));
            categories.add(new Category("0120-0050", "Противогрибковые средства"));
            categories.add(new Category("0120-0050-0010", "Противогрибковые средства в комбинациях"));
            categories.add(new Category("0120-0070", "Противопаразитарные средства"));
            categories.add(new Category("0120-0070-0010", "Противопаразитарные средства в комбинациях"));
            categories.add(new Category("0120-0080", "Синтетические антибактериальные средства"));
            categories.add(new Category("0120-0080-0030", "Другие синтетические антибактериальные средства"));
            categories.add(new Category("0120-0080-0030-0010", "Другие синтетические антибактериальные средства в комбинациях"));
            categories.add(new Category("0120-0080-0010", "Сульфаниламиды"));
            categories.add(new Category("0120-0080-0010-0010", "Сульфаниламиды в комбинациях"));
            categories.add(new Category("0120-0080-0020", "Хинолоны/фторхинолоны"));
            categories.add(new Category("0120-0080-0020-0010", "Хинолоны/фторхинолоны в комбинациях"));

            categories.add(new Category("0130", "Противоопухолевые средства"));
            categories.add(new Category("0130-0010", "Алкилирующие средства"));
            categories.add(new Category("0130-0020", "Антиметаболиты"));
            categories.add(new Category("0130-0070", "Другие противоопухолевые средства"));
            categories.add(new Category("0130-0030", "Противоопухолевые антибиотики"));
            categories.add(new Category("0130-0040", "Противоопухолевые гормональные средства и антагонисты гормонов"));
            categories.add(new Category("0130-0060", "Противоопухолевые средства — ингибиторы протеинкиназ"));
            categories.add(new Category("0130-0055", "Противоопухолевые средства — моноклональные антитела"));
            categories.add(new Category("0130-0055-0056", "Противоопухолевые средства — моноклональные антитела в комбинациях"));
            categories.add(new Category("0130-0050", "Противоопухолевые средства растительного происхождения"));
            categories.add(new Category("0130-0050-0051", "Противоопухолевые средства растительного происхождения в комбинациях"));

            categories.add(new Category("0140", "Регенеранты и репаранты"));
            categories.add(new Category("0140-0010", "Регенеранты и репаранты в комбинациях"));

            categories.add(new Category("0160", "Разные средства"));
            categories.add(new Category("0160-0010", "Вспомогательные вещества, реактивы и полупродукты"));
            categories.add(new Category("0160-0020", "Детское питание (включая смеси)"));
            categories.add(new Category("0160-0120", "Другие разные средства"));
            categories.add(new Category("0160-0050", "Радиопрофилактические и радиотерапевтические средства"));
            categories.add(new Category("0160-0080", "Склерозирующие средства"));
            categories.add(new Category("0160-0090", "Средства для коррекции нарушений при алкоголизме, токсико- и наркомании"));
            categories.add(new Category("0160-0090-0010", "Средства для коррекции нарушений при алкоголизме, токсико- и наркомании в комбинациях"));

            categoryRepository.saveAll(categories);
        }


        if (formRepository.findAll().isEmpty()) {
            List<Form> forms = new ArrayList<>();

            forms.add(new Form("Таблетка"));
            forms.add(new Form("Капсула"));
            forms.add(new Form("Микрокапсула"));
            forms.add(new Form("Нанокапсула"));
            forms.add(new Form("Гранулы"));
            forms.add(new Form("Драже"));
            forms.add(new Form("Пилюля"));
            forms.add(new Form("Пастилки"));
            forms.add(new Form("Порошок"));
            forms.add(new Form("Брикет"));
            forms.add(new Form("Лекарственный карандаш"));
            forms.add(new Form("Жевательная резинка"));
            forms.add(new Form("Пеллеты"));
            forms.add(new Form("Мазь"));
            forms.add(new Form("Крем"));
            forms.add(new Form("Гель"));
            forms.add(new Form("Суппозитории"));
            forms.add(new Form("Линименты"));
            forms.add(new Form("Паста"));
            forms.add(new Form("Пессарий"));
            forms.add(new Form("Пластырь"));
            forms.add(new Form("TTC"));
            forms.add(new Form("Раствор"));
            forms.add(new Form("Суспензия"));
            forms.add(new Form("Эмульсия"));
            forms.add(new Form("Капли"));
            forms.add(new Form("Микстура"));
            forms.add(new Form("Настойка"));
            forms.add(new Form("Настой"));
            forms.add(new Form("Отвар"));
            forms.add(new Form("Сироп"));
            forms.add(new Form("Аэрозоль и спреи"));
            forms.add(new Form("Газы"));
            forms.add(new Form("Лекарственный сбор"));
            forms.add(new Form("Лекарственные формы для инъекций"));

            formRepository.saveAll(forms);
        }


        if (accountingTypeRepository.findAll().isEmpty()) {
            List<AccountingType> accountingTypes = new ArrayList<>();

            accountingTypes.add(new AccountingType("Нет"));
            accountingTypes.add(new AccountingType("Группа 1 (наркотические и психотропные в-ва)"));
            accountingTypes.add(new AccountingType("Группа 2 (сильнодействующие и ядовитые в-ва)"));
            accountingTypes.add(new AccountingType("Группа 3 (комбинированные с наркотическими или психотропными в-вами)"));
            accountingTypes.add(new AccountingType("Группа 4 (иные)"));

            accountingTypeRepository.saveAll(accountingTypes);
        }
    }
}
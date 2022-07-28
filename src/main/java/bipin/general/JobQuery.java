package bipin.general;

import java.util.*;

public class JobQuery {

    static String queries = "engineering,  data, experience  ";

    public static void main(String[] args) {
        // build posting to word/term index (hashmap O(1) -> O(n))
        String[] postings = jobPosting.split("###");
        List<HashMap<String, Integer>> indexedPostings = new ArrayList<>();
        for (String post : postings) {
            indexedPostings.add(wordCount(post));
        }

        // build query to posting sorted tree (treemap O(log n))
        //    but since we will always be looking for the top near O(1) retrieval
        String[] searchQueries = queries.split(",");

        // this should be cached in mem
        Map<String, Map<Integer, String>> queryTermCache = new HashMap<>();

        for(String searchTerm : searchQueries) {
            // descending tree holding posting with most occurrences of search term
            Map<Integer, String> searchTermTree = new TreeMap<>(new DescTreeMapComparator());
            String sanitizedSearchTerm = searchTerm.trim().toLowerCase();

            for (int i = 0; i < indexedPostings.size(); i++) {

                if (indexedPostings.get(i).containsKey(sanitizedSearchTerm)) {
                    // if post contains term add it to the tree
                    searchTermTree.put(indexedPostings.get(i).get(sanitizedSearchTerm), "PostingID#" + i);
                }
            }
            printTree(searchTermTree);
            // trim the tree to the first 1000 (or X elements)
            queryTermCache.put(searchTerm, searchTermTree);
        }

        System.out.println(queryTermCache);
    }

    static class DescTreeMapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    static void printTree(Map<Integer, String> treemap) {
        for (Map.Entry<Integer, String> entry: treemap.entrySet()) {
            System.out.println("Term:" + entry.getValue() + "\tOccurrences:" + entry.getKey());
        }
    }

    static HashMap<String, Integer> wordCount(String textBlock) {
        String[] stringArray =  textBlock.split(" ");
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(String s : stringArray) {
            String cleaned = s.trim()
                    .replaceAll("[^a-zA-Z0-9]+$", "")
                    .toLowerCase();
            if (cleaned.length() > 0) {
                if (!wordMap.containsKey(cleaned)) {
                    wordMap.put(cleaned, 1);
                } else {
                    wordMap.put(cleaned, wordMap.get(cleaned) + 1);
                }
            }
        }
        return wordMap;
    }

    static String jobPosting = "data data data data ###" +
            "engineering engineering engineering At Icario, we know that unicorns don’t exist, but Rhinos sure do! We’re not looking for the impossible, just the exceptional. If you meet a combination of the listed skills below, we encourage you to apply.\n" +
            "\n" +
            "    Desire to solve tough problems by delivering quality cloud software at scale\n" +
            "    Experience building teams where everyone is learning, and everyone contributes as a careful steward of our culture of diversity, inclusion, and trust\n" +
            "    Knowledge of health care data security requirements including HIPAA and HITRUST is a plus\n" +
            "    Experience working in Cloud environments such as AWS, Azure, or GCP\n" +
            "    Prior success as an Engineering Manager and experience leading and building high-performance teams and providing technical direction\n" +
            "    Refine and promote Agile practices to ensure that commitments and capacity are aligned, and ensure timely completion and delivery of features with quality, security, and scalability in mind\n" +
            "    Fluent in driving continuous improvement of development standards, tools, and processes in the department to improve the platform and the developer experience (what’s good for engineers is good for the platform)\n" +
            "    Energized by a modern approach to software delivery and platform development\n" +
            "    Experience actively coaching and mentoring team members in their careers\n" +
            "    Track record in partnering with recruiting to build incredible engineering teams\n" +
            "    Strong communication and collaboration skills\n" +
            "###" +

            "What we're looking for\n" +
            "\n" +
            "KorTerra is looking for a manager to lead a growing team of top software engineers building a world-class product suite. The Software Development Manager is a key position directly responsible for contributing to the success of the KorTerra products and the overall organization. The Development Manager helps advance our software and operations to the next level of quality by leading design, creation, implementation, and operations of mobile and cloud-based products that work in a multi-tenanted, secure, cloud environment. The Development Manager reports to the Director of Product Development and Operations and is a member of the Technology Leadership Team.\n" +
            "\n" +
            "What you'll be doing\n" +
            "\n" +
            "    Lead an Agile/Scrum software development team and drive solutions employing modern cloud technology\n" +
            "    Have a passion for Agile software development and be continually researching industry trends and best practices to introduce to the team\n" +
            "    Work with the development team to collaboratively implement process and policy changes\n" +
            "    Maintain continuous quality assurance and best practice testing automation\n" +
            "    Work closely with our Product Owners with story refinement and prioritization utilizing Behavioral Driven Design\n" +
            "    Conducts regularly scheduled one-on-one meetings and performance appraisals with direct reports\n" +
            "    Work with each member of your team to establish clear goals for professional growth and drive positive outcomes\n" +
            "    Remain vigilant toward changes in technology, how those changes may impact our current and future product offerings, and how improved technologies may help us to better deliver cutting edge software solutions\n" +
            "    Leverage Jira and other software development management tools to schedule work, balance resources, and provide post-mortem analysis of our ongoing development efforts\n" +
            "    Continuously manage the software development cycle and provide detailed progress reporting to technology leadership team so we can be successful in achieving our immediate, mid-range, and long-term company goals\n" +
            "###" +
            " Company\n" +
            "Federal Reserve Bank of Minneapolis\n" +
            "The Federal Reserve Bank of Minneapolis is looking for an experienced Product Manager to join its Aternity Support Office (ASO). Minneapolis IT is operationalizing the product Aternity for end user experience (EUX) monitoring and analysis. Minneapolis IT will be responsible for standing up the Aternity Support Office. In this role you will be responsible for the product planning and execution throughout the Product Lifecycle, including gathering and prioritizing product and customer requirements, defining the product vision, and working closely with engineering, compliance, support, and business partners to turn customer ideas into desirable products and technical solutions. You will also ensure that the product supports the bank's overall strategy and goals.\n" +
            "Position responsibilities include:\n" +
            "\n" +
            "    Analyze business and user needs, document requirements, work with engineers to develop and support the business environment.\n" +
            "    Ensure customer-driven design, considering user pain points and usability test results, while using market & industry knowledge to deliver a well-positioned product.\n" +
            "    Develop strategic product roadmaps, crafting and communicating a vision that is understandable by all stakeholders, while translating the roadmap into requirements for engineering, to ensure successful build and delivery across the product life cycle.\n" +
            "    Identify key opportunities for improvement based on industry best practices and trends, develop technical or process enhancements to increase operational efficiencies, or reduce costs associated with the use of internal tools.\n" +
            "    Anticipate industry and product trends, capability prioritization and tradeoffs, balancing business needs versus technical and resource constraints.\n" +
            "    Communicate portfolio and project updates to managers and stakeholders, creating buy-in on product vision and ensuring or developing strategic alignment.\n" +
            "    Develop content for marketing collateral and support training to ensure successful product launch.\n" +
            "    Define, implement, track measurable individual and team objectives that are aligned with business and organizational goals, using a data-driven approach to iterate on delivery plans and roadmaps based on key metrics captured.\n" +
            "    Create product strategy documentation designed to communicate and evangelize the value of the product or platform across the broader organization.\n" +
            "    Meet regularly with team members to gather work status, discuss work progress or obstacles.\n" +
            "    Work with business partners across the System to develop technology solutions that align with business and technical strategies.\n" +
            "\n" +
            "Qualifications:\n" +
            "\n" +
            "    Bachelor’s Degree in Marketing, Business, Engineering, Information Technology/Systems or related field preferred, or an equivalent combination of education and work experience.\n" +
            "    4+ years of experience developing innovative, technical products for a Product Manager II. 6+ years of experience developing innovative, technical products for a Product Manager III.\n" +
            "    Excellent written and oral communication skills with the ability to communicate with team members, other departments, upper management, and product customers.\n" +
            "    Strong organizational skills, the ability to perform under pressure, and management of multiple priorities with competing demands for resources.\n" +
            "\n" +
            "Preferred Qualifications:\n" +
            "\n" +
            "    Possesses product management skillsets and experience, ability to gain consensus, use influence to achieve decisions and escalate in a timely and clear fashion.\n" +
            "    Working experience with one or more software development life cycle methodologies such as Agile SCRUM.\n" +
            "    Proven ability to collaborate, build relationships and influence individuals at all levels in a matrix-management environment, as well as external vendors and service providers.\n" +
            "    Working knowledge engineering engineering engineering engineering engineering engineering engineering of product development processes including the ability to evaluate and prioritize enhancement requests for products, set product release schedules and create product forecasts.\n" +
            "    IT applications, operations, service and support organizations Product Management Certification.\n" +
            "\n" +
            "Our total rewards program offers benefits that are the best fit for you at every stage of your career:\n" +
            "\n" +
            "    Comprehensive healthcare options (Medical, Dental, and Vision)\n" +
            "    401(k) match, and a fully-funded pension plan\n" +
            "    Paid time off and holidays\n" +
            "    Generously subsidized public transportation\n" +
            "    Annual educational assistance\n" +
            "    On-site fitness facility\n" +
            "    Professional development programs, training and conferences\n" +
            "    And more…\n" +
            "###" +
            "As a Software Engineering Manager on the Robinson Fresh (RF) team at C.H. Robinson you will leverage your previous experience and industry best practices to develop, shape, and lead a software development team that will build the next wave supply chain applications provided by Robinson Fresh. In this role, you will be responsible for driving new development on our proprietary platforms, integrating with 3rd party applications, and supporting the remaining deployments required to sunset legacy systems. You will have the opportunity to collaborate with RF business and technology leaders to paint the vision and construct capability roadmaps that set expectations and design direction.\n" +
            "\n" +
            "Robinson Fresh is a division of CH Robinson that provides product, transportation, and services for a wide variety of customers like retailers, foodservice, wholesalers, and growers.\n" +
            "\n" +
            "C.H. Robinson recognizes the importance of workplace flexibility. We are committed to providing a remote-friendly work environment, both now and in the future. Our global technology teams will continue to have the flexibility that enables you to work where you are most effective, whether that be remote or in the office.\n" +
            "\n" +
            "Responsibilities:\n" +
            "\n" +
            "    Provide leadership and oversight for a team of 15+ that is comprised of Software Engineers, Engineering Product Managers, and Quality Assurance professionals\n" +
            "\n" +
            "    Partner with technology and business leaders to ensure the teams are empowered and obstacles remediated to deliver solid solutions and software for our RF business.\n" +
            "\n" +
            "    Immerse yourself in daily development and Agile process to identify what works best to drive efficiency, quality, and innovation.\n" +
            "\n" +
            "    Gain a thorough understanding of RF sourcing and services business.\n" +
            "\n" +
            "    Continue to learn and optimize the communication and collaboration of teams that are both remote and onsite.\n" +
            "\n" +
            "    Acquire a deep understanding of Managed Procurement, Replenishment, Navisphere (CH Robinson’s technology platform), and Famous (3rd party).\n" +
            "\n" +
            "    Support the new RF technology request process and bring energy and innovation to new areas of development (Warehouse Mgt., PO Mgt.)\n" +
            "\n" +
            "    Support the deployment/testing efforts to sunset Compass and IMS legacy systems.\n" +
            "\n" +
            "    Collaborate with Architecture and other software engineers to ensure that solutions are aligned with CHR target design and architectural best practices.\n" +
            "\n" +
            "    Oversee the career development, performance, and compensation of the RF delivery team.\n" +
            "\n" +
            "    Recruit and grow all roles on the team by identifying needs, building skills and mentoring.\n" +
            "\n" +
            "Required Qualifications:\n" +
            "\n" +
            "    7+ years of professional programming experience using general purpose programming languages such as C# (preferred), Java, JavaScript, C/C++, or Python\n" +
            "    2+ years of experience leading, mentoring, and developing people\n" +
            "    Ability to effectively communicate and collaborate with users, technical teams, and all levels of leadership in technology and Robinson Fresh.\n" +
            "    Experience working on successful projects in an Agile environment that include setting and hitting milestones.\n" +
            "    Strong understanding of how a successful software development team functions and delivers high quality software with urgency\n" +
            "    Bachelor's Degree or equivalent work experience and a high school diploma or GED\n" +
            "\n" +
            "Preferred Qualifications:\n" +
            "\n" +
            "    Strong problem solving, analytical, and programming skills in C#\n" +
            "    Able drive and articulate development based on software design and architectural goals\n" +
            "    Commitment to continuous learning both for yourself and your team\n" +
            "    Values a diverse and inclusive work environment\n" +
            "    Able to thrive in a collaborative, creative, dynamic workplace\n" +
            "    Excellent communication and interpersonal skills\n" +
            "    A growth mindset that is open to giving and receiving feedback\n" +
            "\n" +
            "Equal Opportunity and Affirmative Action Employer\n" +
            "\n" +
            "C.H. Robinson is proud to be an Equal Opportunity and Affirmative Action employer. We believe in equality for all and celebrate the diversity of our employees, customers and communities. We believe this increases creativity and innovation, drives business growth and enables engaged and thriving teams. We’re committed to providing an inclusive environment, free from harassment and discrimination, where all employees feel welcomed, valued and respected." +
            "###" +
            "Our Thermo King business is connecting our transport HVAC and refrigeration products and providing digital solutions to help our customers efficiently protect drivers, passengers, and cargo. Using our connected solutions, our customers reduce fuel consumption, carbon emissions, and downtime while increasing the comfort and safety of passengers and shelf life of cargo, including essential cargo like food and pharmaceuticals.\n" +
            "\n" +
            "We are currently hiring a Controls Software Engineering Manager to join our team to lead a team of Product Owners responsible for managing the execution of multiple embedded software programs and manages local software developers. This role will work leading an agile development team in the creation of embedded software that will support multiple refrigeration and mobile HVAC applications. This software drives the sustainability of our products, helping us meet our company’s goals. Provides direction to offshore teams, manages the staffing of programs and schedule adherence. Leads the software architecture for embedded software.\n" +
            "\n" +
            "The successful candidate will be responsible for managing the team including recruiting new talent, mentoring team members, and promoting their careers. In addition, this role will be responsible for:\n" +
            "\n" +
            "    Fostering a culture of continuous improvement for the team and for the off-site developers\n" +
            "    Delegating tasks to the team and resources outside the team including organizing, mentoring and motivating to create an environment for success\n" +
            "    Working with the broader controls team to coordinate the software development work with the rest of the organization\n" +
            "    Leading the software architecting activities and agile process improvement for the embedded software organization.\n" +
            "    Leading software compliance and security compliance to corporate and industry standards\n" +
            "    Working with your software engineering team, the program management team and the broader organization to plan and execute projects\n" +
            "\n" +
            "\n" +
            "Qualifications:\n" +
            "\n" +
            "    Bachelor's Degree in Engineering or Computer Science (or relevant technical discipline)\n" +
            "    5+ years’ experience in controls, electronics, systems engineering, or software engineering experience is required.\n" +
            "    Experience leading a product development team is desired\n" +
            "    Experience working with offshore developments team is desired\n" +
            "    Excellent verbal and written communication skills\n" +
            "\n" +
            "\n" +
            "Key Competencies:\n" +
            "\n" +
            "    A strong leader who can communicate clearly\n" +
            "    Ability to make priority decisions while iterating and innovating to drive improvements\n" +
            "    Attracting, hiring and maintaining top talent\n" +
            "    Experience with Jira and Confluence including administrating groups in the application desired\n" +
            "    Experience with the Agile Software development process desired\n" +
            "    Experience with Embedded Control Systems, HMI’s and manufacturing test systems desired\n" +
            "    Knowledge in refrigeration, vapor compression or thermodynamics/fluid dynamics is a plus.\n" +
            "    Knowledge in compressors, engines or power electronics is a plus.\n" +
            "    Ability to travel up to 15% in the future internationally\n";
}
